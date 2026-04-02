package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.ordemServico.request.AberturaOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.ExecucaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.FinalizacaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;
import com.weg.oficinactw.application.mapper.OrdemServicoMapper;
import com.weg.oficinactw.domain.model.OrdemServico;
import com.weg.oficinactw.domain.model.Usuario;
import com.weg.oficinactw.domain.model.enums.StatusOrdemServico;
import com.weg.oficinactw.domain.model.enums.TipoUsuario;
import com.weg.oficinactw.domain.service.OrdemServicoService;
import com.weg.oficinactw.infra.repository.OrdemServicoRepositoryJPA;
import com.weg.oficinactw.infra.repository.UsuarioRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    private final OrdemServicoRepositoryJPA ordemServicoRepositoryJPA;
    private final OrdemServicoMapper ordemServicoMapper;
    private final UsuarioRepositoryJPA usuarioRepositoryJPA;

    public OrdemServicoServiceImpl(OrdemServicoRepositoryJPA ordemServicoRepositoryJPA, OrdemServicoMapper ordemServicoMapper, UsuarioRepositoryJPA usuarioRepositoryJPA) {
        this.ordemServicoRepositoryJPA = ordemServicoRepositoryJPA;
        this.ordemServicoMapper = ordemServicoMapper;
        this.usuarioRepositoryJPA = usuarioRepositoryJPA;
    }

    @Override //Long professorId, List<Long> alunosId, String equipamento, String defeito,
    public OrdemServicoResponseDTO abrirOrdemServico(AberturaOrdemServicoRequestDTO aberturaOrdemServicoRequestDTO) {
        try {

            Usuario usuarioProfessor = usuarioRepositoryJPA.findById(aberturaOrdemServicoRequestDTO.professorId())
                    .orElseThrow(() -> new RuntimeException("Erro ao verificar usuario como professor! "));

            if (!TipoUsuario.PROFESSOR.equals(usuarioProfessor.getTipoUsuario())){
                throw new IllegalArgumentException("Somente um professor pode abrir uma ordem de Servico! ");
            }

            List<Usuario> listaAlunos = usuarioRepositoryJPA.findAllById(aberturaOrdemServicoRequestDTO.alunosId());

            if (listaAlunos.isEmpty()){
                throw new IllegalArgumentException("É necessário pelo menos um aluno para abrir uma ordem! ");
            }

            OrdemServico ordemServico = new OrdemServico(
                    listaAlunos,
                    usuarioProfessor,
                    StatusOrdemServico.ABERTA,
                    aberturaOrdemServicoRequestDTO.equipamento(),
                    aberturaOrdemServicoRequestDTO.defeitoRelatado()
            );

            ordemServicoRepositoryJPA.save(ordemServico);

            return ordemServicoMapper.requestToEntity(ordemServico);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrdemServicoResponseDTO registrarExecucao(ExecucaoOrdemServicoRequestDTO execucaoOrdemServicoRequestDTO) {

        List<Usuario> alunos = execucaoOrdemServicoRequestDTO.alunosId().stream()
                .map(id -> usuarioRepositoryJPA.findById(id)
                        .orElseThrow(() -> new RuntimeException("Aluno ID " + id + " não encontrado")))
                .collect(Collectors.toList());

        OrdemServico ordemServico = ordemServicoRepositoryJPA.findById(execucaoOrdemServicoRequestDTO.ordemId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Ordem Servico! "));

        ordemServico.setAlunosEscalados(alunos);
        ordemServico.setStatusOrdemServico(StatusOrdemServico.EXECUTANDO);
        ordemServico.setMateriaisUsados(execucaoOrdemServicoRequestDTO.materiaisUsados());
        ordemServico.setConclusaoTecnica(execucaoOrdemServicoRequestDTO.conclusao());

        ordemServicoRepositoryJPA.save(ordemServico);

        return ordemServicoMapper.requestToEntity(ordemServico);
    }

    @Override
    public OrdemServicoResponseDTO finalizarOrdemServico(FinalizacaoOrdemServicoRequestDTO finalizacaoOrdemServicoRequestDTO) {

        OrdemServico ordemServico = ordemServicoRepositoryJPA.findById(finalizacaoOrdemServicoRequestDTO.ordemId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Ordem Servico! "));

        Usuario usuarioProfessor = usuarioRepositoryJPA.findById(finalizacaoOrdemServicoRequestDTO.professorId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Professor! "));

        ordemServico.setStatusOrdemServico(StatusOrdemServico.CONCLUIDA);

        return ordemServicoMapper.requestToEntity(ordemServico);
    }

    @Override
    public List<OrdemServicoResponseDTO> listarOSAtivas() {
        return List.of();
    }
}
