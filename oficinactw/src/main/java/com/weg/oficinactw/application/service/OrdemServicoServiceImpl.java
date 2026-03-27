package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;
import com.weg.oficinactw.application.mapper.OrdemServicoMapper;
import com.weg.oficinactw.domain.model.OrdemServico;
import com.weg.oficinactw.domain.model.Usuario;
import com.weg.oficinactw.domain.model.enums.TipoUsuario;
import com.weg.oficinactw.domain.service.OrdemServicoService;
import com.weg.oficinactw.infra.repository.OrdemServicoRepositoryJPA;
import com.weg.oficinactw.infra.repository.UsuarioRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public OrdemServicoResponseDTO abrirOrdemServico(Long professorId, List<Long> alunosId, String equipamento, String defeito) {
        try {

            Usuario usuario = usuarioRepositoryJPA.findById(professorId)
                    .orElseThrow(() -> new RuntimeException("Erro ao verificar usuario como professor! "));

            if (!TipoUsuario.PROFESSOR.equals(usuario.getTipoUsuario())){
                throw new IllegalArgumentException("Somente um professor pode abrir uma ordem de Servico! ");
            }

            List<Usuario> listaAlunos = usuarioRepositoryJPA.findAllById(alunosId);

            if (listaAlunos.isEmpty()){
                throw new IllegalArgumentException("É necessário pelo menos um aluno para abrir uma ordem! ");
            }

            OrdemServico ordemServico = new OrdemServico(

            );

            return null;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrdemServicoResponseDTO registrarExecucao(Long ordemServicoId, Long alunoId, String materiais, String laudo) {
        return null;
    }

    @Override
    public OrdemServicoResponseDTO finalizarOrdemServico(Long ordemServicoId, Long professorId) {
        return null;
    }

    @Override
    public List<OrdemServicoResponseDTO> listarOSAtivas() {
        return List.of();
    }
}
