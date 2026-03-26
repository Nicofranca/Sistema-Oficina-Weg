package com.weg.oficinactw.domain.service;

import com.weg.oficinactw.application.dto.usuario.UsuarioRequestDTO;
import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuarioService {
    UsuarioResponseDTO criarUsuario (UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO buscarPorId (Long id);
    boolean validarProfessor(Long id);
    List<UsuarioResponseDTO> listaAlunos();
}
