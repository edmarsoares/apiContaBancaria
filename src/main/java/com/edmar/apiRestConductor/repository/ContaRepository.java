package com.edmar.apiRestConductor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.edmar.apiRestConductor.model.Conta;



/*@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "ContaRepository.findByPessoaIdPessoa",
			   query = "SELECT c from pessoa c WHERE c.pessoa.id_Pessoa = :idPessoa")
})*/
@Transactional(readOnly = false)
public interface ContaRepository extends JpaRepository<Conta, Long>{
	//Conta findByPessoaIdPessoa(@Param("idPessoa") Long pessoaId);
	
	@Modifying
	@Query("update Conta c set c.saldo = c.saldo + ?1 where c.idConta = ?2")
	void setFixedSaldoFor(double  quantidade, Long id);
	
	//@Query("select  c.saldo from Conta c  where c.idConta = ?1")
	Conta findByIdConta(Long id);
	
	@Modifying
	@Query("update Conta c set c.saldo = c.saldo - ?1 where c.idConta = ?2")
	void setFixedSaldo(double  quant, Long id);
	
	
	 
}
