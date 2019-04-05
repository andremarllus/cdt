package br.com.cdt.marketpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdt.marketpay.domain.Example;
import br.com.cdt.marketpay.repository.ExampleRepository;

@Service
public class ExampleService {

	@Autowired
	private ExampleRepository exampleRepository;

	public Example cadastrar(Example example) throws Exception {
		return exampleRepository.save(example);
	}
	
	public List<Example> listar() {
		return exampleRepository.findAll();
	}
	
	public Example pesquisar(Long id) {
		return exampleRepository.findById(id).get();
	}
	
	public void delete(Long id) throws Exception {
		exampleRepository.deleteById(id);
	}
	
}
