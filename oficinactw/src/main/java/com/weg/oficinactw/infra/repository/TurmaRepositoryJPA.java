package com.weg.oficinactw.infra.repository;

import com.weg.oficinactw.domain.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepositoryJPA extends JpaRepository<Turma, Long> {
}
