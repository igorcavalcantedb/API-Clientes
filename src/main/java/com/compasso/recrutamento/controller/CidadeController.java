package com.compasso.recrutamento.controller;

import com.compasso.recrutamento.DTO.CidadeDTO;
import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CidadeController {
    @Autowired
    private CidadeService service;

    @GetMapping("/cidades")
    public Iterable<Cidade> listarTodasCidades(){
            return service.listarTodasCidades();
    }
    @PostMapping("/cidade")
    public ResponseEntity<HttpEntity> adicionarCidade(@RequestBody CidadeDTO cidade){
                    service.adicionarCidade(cidade);
                    return ResponseEntity.ok().build();
    }
    @GetMapping("/cidade/{nome}")
    public Cidade pesquisarCidadePorNome(@PathVariable String nome){
            return service.pesquisaCidadePorNome(nome);
    }
    @GetMapping("/cidades/{estado}")
    public List<Cidade> pesquisarCidadePorEstado(@PathVariable String estado){
            return service.pesquisarPorEstado(estado);
    }
}
