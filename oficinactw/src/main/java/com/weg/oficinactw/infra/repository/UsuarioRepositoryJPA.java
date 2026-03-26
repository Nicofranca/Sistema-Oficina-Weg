package com.weg.oficinactw.infra.repository;

import com.weg.oficinactw.domain.model.Usuario;
import com.weg.oficinactw.domain.model.enums.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Long> {
    Usuario findByProfessor(Long id);
    List<Usuario> findByTipoUsuario(TipoUsuario tipoUsuario);
}
