package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.usuario.UsuarioRequestDTO;
import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;
import com.weg.oficinactw.domain.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public boolean validarProfessor(Long id) {
        return false;
    }

    @Override
    public List<UsuarioResponseDTO> listaAlunos() {
        return List.of();
    }
}
