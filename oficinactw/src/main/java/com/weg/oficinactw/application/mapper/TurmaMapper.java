package com.weg.oficinactw.application.mapper;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;
import com.weg.oficinactw.domain.model.Turma;
import com.weg.oficinactw.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TurmaMapper {

    private final UsuarioMapper usuarioMapper;

    public TurmaMapper(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public Turma requestToEntity(TurmaRequestDTO turmaRequestDTO){
        return new Turma(
                turmaRequestDTO.nome()
        );
    }

    public TurmaResponseDTO requestToEntity(Turma turma){
        return new TurmaResponseDTO(
                turma.getId(),
                turma.getNome(),
                turma.getQuantidadeAlnos(),
                turma.getAlunos().stream()
                        .map(usuarioMapper::responseToEntity)
                        .collect(Collectors.toList())
        );
    }
}
