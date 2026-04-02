package com.weg.oficinactw.infra.web.controller;

import com.weg.oficinactw.application.dto.ordemServico.request.AberturaOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.ExecucaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.FinalizacaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;
import com.weg.oficinactw.domain.service.OrdemServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordemservico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public OrdemServicoResponseDTO abrirOrdemServico(@RequestBody AberturaOrdemServicoRequestDTO aberturaOrdemServicoRequestDTO) {
        return ordemServicoService.abrirOrdemServico(aberturaOrdemServicoRequestDTO);
    }

    @PostMapping
    public OrdemServicoResponseDTO registrarExecucao(@RequestBody ExecucaoOrdemServicoRequestDTO execucaoOrdemServicoRequestDTO) {
        return ordemServicoService.registrarExecucao(execucaoOrdemServicoRequestDTO);
    }

    @PostMapping
    public OrdemServicoResponseDTO finalizarOrdemServico(@RequestBody FinalizacaoOrdemServicoRequestDTO finalizacaoOrdemServicoRequestDTO) {
        return ordemServicoService.finalizarOrdemServico(finalizacaoOrdemServicoRequestDTO);
    }

    @GetMapping
    public List<OrdemServicoResponseDTO> listarOSAtivas() {
        return ordemServicoService.listarOSAtivas();
    }
}
