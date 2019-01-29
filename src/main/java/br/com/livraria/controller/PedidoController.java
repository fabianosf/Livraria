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

import br.com.livraria.model.Pedido;
import br.com.livraria.service.PedidoService;

@RestController
@RequestMapping(value = "/api")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pedido>> getPedidos() {
		Collection<Pedido> pedidos = pedidoService.findAll();
		return new ResponseEntity<Collection<Pedido>>(pedidos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pedidos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> getPedido(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findOne(id);
		if (pedido == null) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pedidos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
		Pedido savedPedido = pedidoService.create(pedido);
		return new ResponseEntity<Pedido>(savedPedido, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/pedidos/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> updatePedido(@PathVariable("id") Long id, @RequestBody Pedido pedido) {
		Pedido updatedPedido = null;
		if (pedido != null && id == pedido.getId()) {
			updatedPedido = pedidoService.update(pedido);
		}
		if (updatedPedido == null) {
			return new ResponseEntity<Pedido>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pedido>(updatedPedido, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pedidos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pedido> deletePedido(@PathVariable("id") Long id) {
		pedidoService.delete(id);
		return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
