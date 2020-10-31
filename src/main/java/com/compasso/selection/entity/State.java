package com.compasso.recrutamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Estado {
    private @Id @GeneratedValue Long id;
    
    @Column
    @NotNull
    @Size(max = 2)
    private String sigla;
    @Column
    @NotNull
    @Size(max = 50)
    private String nome;
    
    @OneToMany(mappedBy="estado")
    private List<Cidade> cidades;
    

    public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estado(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
