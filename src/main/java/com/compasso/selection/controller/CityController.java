package com.compasso.recrutamento.controller;

import com.compasso.recrutamento.DTO.CidadeDTO;
import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.service.CidadeService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cidade")
public class CidadeController {
	@Autowired
	private CidadeService service;

	@GetMapping("/todas")
	@ApiOperation(value = "Listar todas as cidades ")
	public Iterable<Cidade> listarTodasCidades() {
		return service.listarTodasCidades();
	}

	@ApiOperation(value = "Adicionar Cidade à Estado(UF) ")
	@PostMapping()
	public ResponseEntity<HttpEntity> adicionarCidade(@RequestBody CidadeDTO cidade) {
		service.adicionarCidade(cidade);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Pesquisar cidade por nome ")
	@GetMapping("/{nome}")
	public Cidade pesquisarCidadePorNome(@PathVariable String nome) {
		return service.pesquisaCidadePorNome(nome);
	}

	@ApiOperation(value = "Listar as cidade de um Estado(UF) ")
	@GetMapping()
	public List<Cidade> pesquisarCidadePorEstado(@RequestParam String uf) {
		return service.pesquisarPorEstado(uf);
	}
}
