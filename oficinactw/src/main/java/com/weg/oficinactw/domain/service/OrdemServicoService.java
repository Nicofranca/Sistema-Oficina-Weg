package com.weg.oficinactw.domain.service;

import com.weg.oficinactw.application.dto.ordemServico.OrdemServicoResponseDTO;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoResponseDTO abrirOrdemServico (Long professorId, List<Long> alunosId, String equipamento, String defeito);
    OrdemServicoResponseDTO registrarExecucao (Long ordemServicoId, Long alunoId, String materiais, String laudo);
    OrdemServicoResponseDTO finalizarOrdemServico (Long ordemServicoId, Long professorId);
    List<OrdemServicoResponseDTO> listarOSAtivas (); //Retorna apenas as que são concluidas
}

