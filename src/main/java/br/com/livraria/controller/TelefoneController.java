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

import br.com.livraria.model.Telefone;
import br.com.livraria.service.TelefoneService;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@Controller
public class TelefoneController {
	
	@Autowired
	private TelefoneService telefoneService;
	
	@RequestMapping(value = "/telefones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Telefone>> getTelefones() {
		Collection<Telefone> telefones = telefoneService.findAll();
		return new ResponseEntity<Collection<Telefone>>(telefones, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/telefones/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> getTelefone(@PathVariable("id") Long id) {
		Telefone telefone = telefoneService.findOne(id);
		if (telefone == null) {
			return new ResponseEntity<Telefone>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/telefones", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> createTelefone(@RequestBody Telefone telefone) {
		Telefone savedTelefone = telefoneService.create(telefone);
		return new ResponseEntity<Telefone>(savedTelefone, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/telefones/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> updateTelefone(@PathVariable("id") Long id, @RequestBody Telefone telefone) {
		Telefone updatedTelefone = null;
		if (telefone != null && id == telefone.getId()) {
			updatedTelefone = telefoneService.update(telefone);
		}
		if (updatedTelefone == null) {
			return new ResponseEntity<Telefone>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Telefone>(updatedTelefone, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/telefones/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Telefone> deleteTelefone(@PathVariable("id") Long id) {
		telefoneService.delete(id);
		return new ResponseEntity<Telefone>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
