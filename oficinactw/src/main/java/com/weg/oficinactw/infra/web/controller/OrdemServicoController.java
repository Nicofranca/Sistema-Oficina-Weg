package com.weg.oficinactw.infra.web.controller;

import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;
import com.weg.oficinactw.domain.service.OrdemServicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ordemservico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public OrdemServicoResponseDTO abrirOrdemServico(Long professorId, List<Long> alunosId, String equipamento, String defeito) {
        return ordemServicoService.abrirOrdemServico(professorId, alunosId, equipamento, defeito);
    }

    @PostMapping
    public OrdemServicoResponseDTO registrarExecucao(Long ordemServicoId, Long alunoId, String materiais, String laudo) {
        return ordemServicoService.registrarExecucao(ordemServicoId, alunoId, materiais, laudo);
    }

    @PostMapping
    public OrdemServicoResponseDTO finalizarOrdemServico(Long ordemServicoId, Long professorId) {
        return ordemServicoService.finalizarOrdemServico(ordemServicoId, professorId);
    }

    @GetMapping
    public List<OrdemServicoResponseDTO> listarOSAtivas() {
        return ordemServicoService.listarOSAtivas();
    }
}
