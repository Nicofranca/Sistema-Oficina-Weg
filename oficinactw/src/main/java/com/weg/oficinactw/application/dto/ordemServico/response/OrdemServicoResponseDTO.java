package com.weg.oficinactw.application.dto.ordemServico.response;

import com.weg.oficinactw.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public record OrdemServicoResponseDTO(
        Long id,
        String equipamento,
        String defeitoRelatado,
        String status,
        String materiaisUsados,
        String conclusaoTecnica,
        UsuarioResponseDTO professorResponseDTO,
        List<UsuarioResponseDTO> alunosEscalados
) {
}
