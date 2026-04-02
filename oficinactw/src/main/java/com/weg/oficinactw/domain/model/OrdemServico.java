package com.weg.oficinactw.domain.model;

import com.weg.oficinactw.domain.model.enums.StatusOrdemServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String defeitoRelatado;

    @Column
    private String materiaisUsados;

    @Column
    private String conclusaoTecnica;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdemServico;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Usuario professorResponsavel;

    @ManyToMany
    @JoinTable(
            name = "os_alunos",
            joinColumns = @JoinColumn(name = "os_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Usuario> alunosEscalados;

    public OrdemServico(List<Usuario> alunosEscalados, Usuario professorResponsavel, StatusOrdemServico statusOrdemServico, String nome, String defeitoRelatado) {
        this.alunosEscalados = alunosEscalados;
        this.professorResponsavel = professorResponsavel;
        this.statusOrdemServico = statusOrdemServico;
        this.nome = nome;
        this.defeitoRelatado = defeitoRelatado;
    }

    public OrdemServico(List<Usuario> alunosEscalados, StatusOrdemServico statusOrdemServico, String conclusaoTecnica, String materiaisUsados) {
        this.alunosEscalados = alunosEscalados;
        this.statusOrdemServico = statusOrdemServico;
        this.conclusaoTecnica = conclusaoTecnica;
        this.materiaisUsados = materiaisUsados;
    }
}
