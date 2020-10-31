package com.compasso.recrutamento.entity;

import com.compasso.recrutamento.DTO.ClienteDTO;
import com.compasso.recrutamento.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;
@Entity
public class Cliente {
    private @Id
    @GeneratedValue
    Long id;
    private String nome;
    private Sexo sexo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private int idade;
    @ManyToOne
    private Cidade cidade;

    public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public Cliente(ClienteDTO clienteDTO , Cidade cidade) {
    	this.nome = clienteDTO.getNome();
    	this.sexo= clienteDTO.getSexo();
    	this.dataNascimento = LocalDate.parse(clienteDTO.getDataNascimento());
    	this.idade = clienteDTO.getIdade();
    	this.cidade = cidade;

    	
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
