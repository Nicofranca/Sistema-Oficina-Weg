package com.weg.oficinactw.infra.web.controller;

import com.weg.oficinactw.application.dto.usuario.UsuarioRequestDTO;
import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;
import com.weg.oficinactw.domain.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listaAlunos() {
        return usuarioService.listaAlunos();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioService.buscarPorId(id);
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.criarUsuario(usuarioRequestDTO);
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
