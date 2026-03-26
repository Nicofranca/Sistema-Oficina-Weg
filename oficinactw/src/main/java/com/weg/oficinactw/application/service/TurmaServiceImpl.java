package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;
import com.weg.oficinactw.application.mapper.TurmaMapper;
import com.weg.oficinactw.domain.service.TurmaService;
import com.weg.oficinactw.infra.repository.TurmaRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepositoryJPA turmaRepositoryJPA;
    private final TurmaMapper turmaMapper;

    public TurmaServiceImpl(TurmaRepositoryJPA turmaRepositoryJPA, TurmaMapper turmaMapper) {
        this.turmaRepositoryJPA = turmaRepositoryJPA;
        this.turmaMapper = turmaMapper;
    }

    @Override
    public TurmaResponseDTO criarTurma(TurmaRequestDTO turmaRequestDTO) {


        return null;
    }

    @Override
    public void matricularAluno(Long turmaId, Long alunoId) {

    }

    @Override
    public List<TurmaResponseDTO> listarTurmas() {
        return List.of();
    }
}
