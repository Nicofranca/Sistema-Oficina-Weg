package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;
import com.weg.oficinactw.domain.service.TurmaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {
    @Override
    public TurmaResponseDTO criarTurma(TurmaRequestDTO turmaRequestDTO) {
        return null;
    }

    @Override
    public void matricularAluno(Long turmaId, Long alunoId) {

    }

    @Override
    public List<TurmaResponseDTO> listarAlunos() {
        return List.of();
    }
}
