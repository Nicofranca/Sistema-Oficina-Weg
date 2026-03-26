package com.weg.oficinactw.domain.service;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;

import java.util.List;

public interface TurmaService {
    TurmaResponseDTO criarTurma(TurmaRequestDTO turmaRequestDTO);
    void matricularAluno (Long turmaId, Long alunoId);
    List<TurmaResponseDTO> listarAlunos();
}
