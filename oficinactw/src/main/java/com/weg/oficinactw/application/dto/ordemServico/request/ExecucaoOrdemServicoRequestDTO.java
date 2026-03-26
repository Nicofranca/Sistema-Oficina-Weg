package com.weg.oficinactw.application.dto.ordemServico.request;

import java.util.List;

public record ExecucaoOrdemServicoRequestDTO(
        Long alunosId,
        String materiaisUsados,
        String comclusao
) {
}
