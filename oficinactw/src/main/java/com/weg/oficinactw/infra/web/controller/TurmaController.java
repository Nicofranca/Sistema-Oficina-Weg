package com.weg.oficinactw.infra.web.controller;

import com.weg.oficinactw.application.dto.turma.TurmaRequestDTO;
import com.weg.oficinactw.application.dto.turma.TurmaResponseDTO;
import com.weg.oficinactw.domain.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaResponseDTO criarTurma(@RequestBody TurmaRequestDTO turmaRequestDTO) {
        return turmaService.criarTurma(turmaRequestDTO);
    }

    @PostMapping("/{turmaId}") // pega o id da turma na URL e o id do aluno no body
    public void matricularAluno(@PathVariable Long turmaId, @RequestBody Long alunoId ) {
        turmaService.matricularAluno(turmaId, alunoId);
    }

    @GetMapping
    public List<TurmaResponseDTO> listarTurmas() {
        return turmaService.listarTurmas();
    }
}
