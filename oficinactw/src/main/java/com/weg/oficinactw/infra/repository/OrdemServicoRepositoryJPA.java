package com.weg.oficinactw.infra.repository;

import com.weg.oficinactw.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepositoryJPA extends JpaRepository<OrdemServico, Long> {
}
