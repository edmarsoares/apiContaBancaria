package com.edmar.apiRestConductor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edmar.apiRestConductor.model.Conta;
import com.edmar.apiRestConductor.model.Transacao;
import com.edmar.apiRestConductor.repository.TransacaoRepository;


@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public Transacao salvar(Transacao trans) {
		return transacaoRepository.save(trans);
	}
	
	public List<Transacao> listar() {
		return transacaoRepository.findAll();
	}
	
	public void delete(Long id) {
		transacaoRepository.deleteById(id);
	}
	
	public void buscarPeloId(Long id) {
		transacaoRepository.findById(id);
	}
	
	public List<Transacao> buscarContas(Conta conta) {
		return transacaoRepository.findByContaIn(conta);
	}
}
