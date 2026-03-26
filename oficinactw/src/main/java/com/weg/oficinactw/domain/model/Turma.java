package com.weg.oficinactw.domain.model;

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
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "turma")
    private List<Usuario> alunos;

    public int getQuantidadeAlnos(){
        return (this.alunos != null) ? this.alunos.size() : 0;
    }

    public Turma(String nome) {
        this.nome = nome;
    }
}
