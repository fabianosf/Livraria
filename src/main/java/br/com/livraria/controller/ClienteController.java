package br.com.livraria.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.livraria.model.Cliente;
import br.com.livraria.service.ClienteService;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */


@RestController
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> getClientes() {
		Collection<Cliente> clientes = clienteService.findAll();
		return new ResponseEntity<Collection<Cliente>>(clientes, HttpStatus.OK);
	}

	@RequestMapping(value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		Cliente savedCliente = clienteService.create(cliente);
		return new ResponseEntity<Cliente>(savedCliente, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/greetings/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente updatedCliente = null;
		if (cliente != null && id == cliente.getId()) {
			updatedCliente = clienteService.update(cliente);
		}
		if (updatedCliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);
	}

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id) {
		clienteService.delete(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}

}
