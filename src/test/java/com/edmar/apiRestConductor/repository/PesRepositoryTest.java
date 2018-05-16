package com.edmar.apiRestConductor.repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.edmar.apiRestConductor.model.Pessoa;
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PesRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;
	private static final String cpf = "12345678912";
	private static final String cpfInvalido = "1234567";
	
	
	@Before
	public void setUp() throws Exception {
		Pessoa pessoa =  new Pessoa();
		pessoa.setNome("edmar");
		pessoa.setCpf(cpf);
		this.pessoaRepository.save(pessoa);
	}
	
	@Test
	public void testBuscarPorCpfValido() {
		Pessoa pessoa = this.pessoaRepository.findByCpf(cpf);
		assertEquals(cpf, pessoa.getCpf());
	}
	@Test
	public void testBuscarPorCpfInvalido() {
		Pessoa pessoa = this.pessoaRepository.findByCpf(cpf);
		assertNotEquals(cpfInvalido, pessoa);
	}
	
	@After
	public final void tearDown() {
		this.pessoaRepository.deleteAll();
	}


}
