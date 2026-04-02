package com.weg.oficinactw.application.dto.ordemServico.request;

import java.util.List;

public record AberturaOrdemServicoRequestDTO(
        String equipamento,
        String defeitoRelatado,
        Long professorId,
        List<Long> alunosId
) {
}
