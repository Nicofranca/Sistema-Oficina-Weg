package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.usuario.UsuarioRequestDTO;
import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;
import com.weg.oficinactw.application.mapper.UsuarioMapper;
import com.weg.oficinactw.domain.model.Usuario;
import com.weg.oficinactw.domain.model.enums.TipoUsuario;
import com.weg.oficinactw.domain.service.UsuarioService;
import com.weg.oficinactw.infra.repository.UsuarioRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private  final UsuarioRepositoryJPA usuarioRepositoryJPA;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepositoryJPA usuarioRepositoryJPA) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepositoryJPA = usuarioRepositoryJPA;
    }

    @Override
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        try {
            Usuario usuario = usuarioMapper.requestToEntity(usuarioRequestDTO);

            usuarioRepositoryJPA.save(usuario);

            return usuarioMapper.responseToEntity(usuario);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        try {
            Usuario usuario = usuarioRepositoryJPA.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao buscar usuario por ID!"));

            return usuarioMapper.responseToEntity(usuario);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validarProfessor(Long id) {
        try {

            Usuario usuario = usuarioRepositoryJPA.findById(id)
                    .orElseThrow(() -> new RuntimeException("Erro ao validar professor com id! "));

            return TipoUsuario.PROFESSOR.equals(usuario.getTipoUsuario());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UsuarioResponseDTO> listaAlunos() {

        try {
            return usuarioRepositoryJPA.findByTipoUsuario(TipoUsuario.ALUNO).stream()
                    .map(usuarioMapper::responseToEntity)
                    .toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
