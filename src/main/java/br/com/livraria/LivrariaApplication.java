package br.com.livraria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Endereco;
import br.com.livraria.model.Login;
import br.com.livraria.model.Telefone;
import br.com.livraria.model.Tipo;
import br.com.livraria.repository.ClienteRepository;
import br.com.livraria.repository.EnderecoRepository;
import br.com.livraria.repository.LoginRepository;
import br.com.livraria.repository.TelefoneRepository;
/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		Cliente cliente = new Cliente("Maria","Flores");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua das Violetas");
		endereco.setNumero("45");
		endereco.setBairro("Pedra");
		endereco.setComplemento("Casa");
		endereco.setReferencia("Casa da Mata");
		endereco.setUf("RJ");
		endereco.setCliente(cliente);
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(endereco);
		cliente.setEnderecos(enderecos);
		
		Login login = new Login();
		login.setApelido("mflores");
		login.setSenha("123");
		login.setCliente(cliente);
		cliente.setLogin(login);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Paulo");
		cliente2.setSobrenome("Silva");
		
		Telefone telefone = new Telefone();
		telefone.setDdd("22");
		telefone.setTipo(Tipo.CASA);
		telefone.setNumero("22645587");
		List<Cliente>clientes = new ArrayList<Cliente>();
		clientes.add(cliente2);
		telefone.setClientes(clientes);
		
		
				
		clienteRepository.save(cliente);
		enderecoRepository.save(endereco);
		loginRepository.save(login);
		telefoneRepository.save(telefone);
		 
		
		
		
		
		
	}

}

