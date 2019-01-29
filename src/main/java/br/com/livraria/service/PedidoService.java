package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Pedido;

/**
 * 
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */


public interface PedidoService {

	Collection<Pedido> findAll();
	Pedido findOne(Long id);
	Pedido create(Pedido pedido);
	Pedido update(Pedido pedido);
	void delete(Long id);

	
	
}
