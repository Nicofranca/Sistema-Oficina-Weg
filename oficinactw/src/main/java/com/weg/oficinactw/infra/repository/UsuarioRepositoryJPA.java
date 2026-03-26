package com.weg.oficinactw.infra.repository;

import com.weg.oficinactw.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Long> {
}
