package com.weg.oficinactw.application.dto.usuario;

import com.weg.oficinactw.domain.model.enums.TipoUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        TipoUsuario tipoUsuario
) {
}
