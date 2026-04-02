package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;
import com.weg.oficinactw.application.mapper.TurmaMapper;
import com.weg.oficinactw.domain.model.Turma;
import com.weg.oficinactw.domain.model.Usuario;
import com.weg.oficinactw.domain.model.enums.TipoUsuario;
import com.weg.oficinactw.domain.service.TurmaService;
import com.weg.oficinactw.infra.repository.TurmaRepositoryJPA;
import com.weg.oficinactw.infra.repository.UsuarioRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepositoryJPA turmaRepositoryJPA;
    private final TurmaMapper turmaMapper;
    private final UsuarioRepositoryJPA usuarioRepositoryJPA;

    public TurmaServiceImpl(TurmaRepositoryJPA turmaRepositoryJPA, TurmaMapper turmaMapper, UsuarioRepositoryJPA usuarioRepositoryJPA) {
        this.turmaRepositoryJPA = turmaRepositoryJPA;
        this.turmaMapper = turmaMapper;
        this.usuarioRepositoryJPA = usuarioRepositoryJPA;
    }

    @Override
    public TurmaResponseDTO criarTurma(TurmaRequestDTO turmaRequestDTO) {
        try {
            Turma turma = turmaMapper.requestToEntity(turmaRequestDTO);

            turmaRepositoryJPA.save(turma);

            return turmaMapper.responseToEntity(turma);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void matricularAluno(Long turmaId, Long alunoId) {
        try {
            Turma turma = turmaRepositoryJPA.findById(turmaId)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar Turma por ID! "));

            Usuario aluno = usuarioRepositoryJPA.findById(alunoId)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar Aluno por ID! "));

            if (!TipoUsuario.ALUNO.equals(aluno.getTipoUsuario())){
                throw new RuntimeException("ID não remetente à um aluno! ");
            }

            aluno.setTurma(turma);

            usuarioRepositoryJPA.save(aluno);


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TurmaResponseDTO> listarTurmas() {
        try {
            return turmaRepositoryJPA.findAll().stream()
                    .map(turmaMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
