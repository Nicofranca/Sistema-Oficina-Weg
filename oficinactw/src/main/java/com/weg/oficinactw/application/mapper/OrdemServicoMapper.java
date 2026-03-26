package com.weg.oficinactw.application.mapper;

import com.weg.oficinactw.application.dto.ordemServico.response.OrdemServicoResponseDTO;
import com.weg.oficinactw.domain.model.OrdemServico;
import org.springframework.stereotype.Component;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class OrdemServicoMapper {

    private final UsuarioMapper usuarioMapper;

    public OrdemServicoMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public OrdemServicoResponseDTO requestToEntity(OrdemServico ordemServico){
        return new OrdemServicoResponseDTO(
                ordemServico.getId(),
                ordemServico.getNome(),
                ordemServico.getDefeitoRelatado(),
                ordemServico.getStatusOrdemServico().name(),
                ordemServico.getMateriaisUsados(),
                ordemServico.getConclusaoTecnica(),
                ordemServico.getProfessorResponsavel() != null ? usuarioMapper.responseToEntity(ordemServico.getProfessorResponsavel()) : null,
                ordemServico.getAlunosEscalados().stream()
                        .map(usuarioMapper::responseToEntity)
                        .collect(Collectors.toList())
        );
    }
}
