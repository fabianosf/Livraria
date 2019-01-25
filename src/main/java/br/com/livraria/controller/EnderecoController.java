package br.com.livraria.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.livraria.model.Endereco;
import br.com.livraria.service.EnderecoService;

/**
 * 
 * @author Fabiano Freitas email: fabiano.freitas@gmail.com
 *
 */
@Controller
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(value = "/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Endereco>> getEnderecos() {
		Collection<Endereco> enderecos = enderecoService.findAll();
		return new ResponseEntity<Collection<Endereco>>(enderecos, HttpStatus.OK);
	}

	@RequestMapping(value = "/enderecos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> getEndereco(@PathVariable("id") Long id) {
		Endereco endereco = enderecoService.findOne(id);
		if (endereco == null) {
			return new ResponseEntity<Endereco>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	}

	@RequestMapping(value = "/enderecos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
		Endereco savedEndereco = enderecoService.create(endereco);
		return new ResponseEntity<Endereco>(savedEndereco, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
		Endereco updatedEndereco = null;
		if (endereco != null && id == endereco.getId()) {
			updatedEndereco = enderecoService.update(endereco);
		}
		if (updatedEndereco == null) {
			return new ResponseEntity<Endereco>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Endereco>(updatedEndereco, HttpStatus.OK);
	}

	@RequestMapping(value = "/enderecos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Endereco> deleteEndereco(@PathVariable("id") Long id) {
		enderecoService.delete(id);
		return new ResponseEntity<Endereco>(HttpStatus.NO_CONTENT);
	}

}
