package com.weg.oficinactw.application.dto.ordemServico.request;

import java.util.List;

public record AberturaOrdemServicoRequestDTO(
        Long professorId,
        String equipamento,
        String defeitoRelatado,
        List<Long> alunosId
) {
}
