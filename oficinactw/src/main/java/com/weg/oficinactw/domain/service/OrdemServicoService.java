package com.weg.oficinactw.domain.service;

import com.weg.oficinactw.application.dto.ordemServico.request.AberturaOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.ExecucaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.request.FinalizacaoOrdemServicoRequestDTO;
import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoResponseDTO abrirOrdemServico (AberturaOrdemServicoRequestDTO aberturaOrdemServicoRequestDTO);
    OrdemServicoResponseDTO registrarExecucao (ExecucaoOrdemServicoRequestDTO execucaoOrdemServicoRequestDTO);
    OrdemServicoResponseDTO finalizarOrdemServico (FinalizacaoOrdemServicoRequestDTO finalizacaoOrdemServicoRequestDTO);
    List<OrdemServicoResponseDTO> listarOSAtivas (); //Retorna apenas as que são concluidas
}

