package com.weg.oficinactw.application.dto.turma;

public record TurmaRequestDTO(
        String nome,
        int quantidadeAlunos,
        Long professorId
) {
}
