package com.edmar.apiRestConductor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edmar.apiRestConductor.model.Conta;
import com.edmar.apiRestConductor.model.Transacao;
import com.edmar.apiRestConductor.repository.ContaRepository;
import com.edmar.apiRestConductor.repository.TransacaoRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private TransacaoService transService;
	
	public Conta salvar(Conta conta) {
		return contaRepository.save(conta);
	}
	
	public void deposita( double quantidade, Long id) {
		contaRepository.setFixedSaldoFor(quantidade, id);
	}
	
	public void sacar( double quantidade, Long id) {
		contaRepository.setFixedSaldo(quantidade, id);
	}
	
	public Conta buscarSado(Long id) {
		return contaRepository.findByIdConta(id);
	}
	
	public List<Conta> listar() {
		return contaRepository.findAll();
	}
	public Conta verificarConta(Long id) {
		return contaRepository.findByIdConta(id);
	}
	
	public List<Transacao> extratoConta(Long id) {
		Conta c = verificarConta(id);
		return transService.buscarContas(c);
		
    }

	
}
