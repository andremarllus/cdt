package br.com.cdt.marketpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cdt.marketpay.domain.Example;

@Repository
public interface ExampleRepository  extends JpaRepository<Example, Long> {
	
	Example findByNomeAndIdade(String nome, Integer idade);
}
