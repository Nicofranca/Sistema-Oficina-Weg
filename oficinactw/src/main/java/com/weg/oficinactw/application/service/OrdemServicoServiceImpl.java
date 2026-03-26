package com.weg.oficinactw.application.service;

import com.weg.oficinactw.application.dto.ordemServico.OrdemServicoResponseDTO;
import com.weg.oficinactw.domain.service.OrdemServicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {
    @Override
    public OrdemServicoResponseDTO abrirOrdemServico(Long professorId, List<Long> alunosId, String equipamento, String defeito) {
        return null;
    }

    @Override
    public OrdemServicoResponseDTO registrarExecucao(Long ordemServicoId, Long alunoId, String materiais, String laudo) {
        return null;
    }

    @Override
    public OrdemServicoResponseDTO finalizarOrdemServico(Long ordemServicoId, Long professorId) {
        return null;
    }

    @Override
    public List<OrdemServicoResponseDTO> listarOSAtivas() {
        return List.of();
    }
}
