package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Pedido;
import br.com.livraria.repository.PedidoRepository;

@Service
public class PedidoServiceBean implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Collection<Pedido> findAll() {
		 Collection<Pedido> pedidos = (Collection<Pedido>) pedidoRepository.findAll();
		 return pedidos;
	}

	@Override
	public Pedido findOne(Long id) {
		 Pedido pedido = pedidoRepository.findOne(id);
		 return pedido;
	}

	@Override
	public Pedido create(Pedido pedido) {
		 if(pedido.getId() != null) {
			 return null;
		 }
		 Pedido savePedido = pedidoRepository.save(pedido);
		 return savePedido;
	}

	@Override
	public Pedido update(Pedido pedido) {
		 Pedido pedidoPersiste = findOne(pedido.getId());
		 if(pedidoPersiste == null) {
			 return null;
		 }
		 Pedido updatePedido = pedidoRepository.save(pedido);
		 return updatePedido;
		 
	}

	@Override
	public void delete(Long id) {
		pedidoRepository.delete(id);
		
	}
	
	
	 

}
