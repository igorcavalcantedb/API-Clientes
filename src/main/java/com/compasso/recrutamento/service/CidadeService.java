package com.compasso.recrutamento.service;

import com.compasso.recrutamento.DTO.CidadeDTO;
import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.entity.Estado;
import com.compasso.recrutamento.repository.CidadeRepository;
import com.compasso.recrutamento.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Iterable<Cidade> listarTodasCidades(){
        return cidadeRepository.findAll();
    }

    public void adicionarCidade(CidadeDTO cidadeDto) {
        Optional<Estado> estadoOptional = estadoRepository.findBySigla(cidadeDto.getSiglaEstado());
        //Todo Tratar o erro se nao retornar nenhum estado
        Estado estado = estadoOptional.get();
        Cidade cidade = new Cidade(cidadeDto.getNome(),estado);
        cidadeRepository.save(cidade);
    }
    
    public Cidade pesquisaCidadePorNome(String nome) {
     	return cidadeRepository.findByNome(nome);
	  	
    }
    
	public List<Cidade> pesquisarPorEstado(String siglaEstado){
		Optional<Estado> estadoOptional = estadoRepository.findBySigla(siglaEstado);
        //Todo Tratar o erro se nao retornar nenhum estado
        Estado estado = estadoOptional.get();
        List<Cidade> cidades = cidadeRepository.findByEstado(estado);
		return cidades;
		
		
	}
}
