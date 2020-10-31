package com.compasso.recrutamento.entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Cidade {
    private @Id
    @GeneratedValue
    Long id;
    
    @Column
    @NotNull
    @Size(max = 100)
    private String nome;
    @JsonIgnore
    @ManyToOne
    private Estado estado;
    

    public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
