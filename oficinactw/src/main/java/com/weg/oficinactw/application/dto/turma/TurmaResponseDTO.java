package com.weg.oficinactw.application.dto.turma;

import com.weg.oficinactw.domain.model.Usuario;

import java.util.List;

public record TurmaResponseDTO(
        Long id,
        String nome,
        int qunatidadeAlunos,
        List<Usuario> alunos
) {
}
