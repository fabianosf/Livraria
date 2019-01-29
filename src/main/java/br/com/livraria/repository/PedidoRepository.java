package br.com.livraria.repository;
import org.springframework.data.repository.CrudRepository;
import br.com.livraria.model.Pedido;

/**
 * 
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
