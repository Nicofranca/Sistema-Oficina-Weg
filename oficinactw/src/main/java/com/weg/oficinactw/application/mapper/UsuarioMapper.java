package com.weg.oficinactw.application.mapper;

import com.weg.oficinactw.application.dto.usuario.UsuarioRequestDTO;
import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;
import com.weg.oficinactw.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario requestToEntity(UsuarioRequestDTO usuarioRequestDTO){
        return new Usuario(
                usuarioRequestDTO.nome(),
                usuarioRequestDTO.tipo()
        );
    }

    public UsuarioResponseDTO responseToEntity(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTipoUsuario()
        );
    }
}
