package br.com.cdt.marketpay.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdt.marketpay.domain.Example;
import br.com.cdt.marketpay.service.ExampleService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/cdt", produces = MediaType.APPLICATION_JSON_VALUE)		
public class ExampleResource {

	@Autowired
	private ExampleService exampleService;
	
	@PostMapping("/")
	@ApiOperation(value = "Este serviço eh um example.",notes = "efetua o cadastro de example")
	public ResponseEntity<Example> cadastro(@Valid @RequestBody Example request) throws Exception {
		Example example = exampleService.cadastrar(request);
		return ResponseEntity.ok(example);
	}
	
	@GetMapping("/")
	@ApiOperation(value = "Este serviço que recupa example.",notes = "efetua o recupera todos os example")
	public ResponseEntity<List<Example>> get() throws Exception {
		return ResponseEntity.ok(exampleService.listar());
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Este serviço que recupa example.",notes = "efetua o recupera todos os example")
	public ResponseEntity<Example> get(@PathVariable("id") Long id ) throws Exception {
		return ResponseEntity.ok(exampleService.pesquisar(id));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Este serviço que recupa example.",notes = "efetua o recupera todos os example")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id ) throws Exception {
		exampleService.delete(id);
		return ResponseEntity.ok().build();
	}
}
