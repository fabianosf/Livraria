package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Login;
import br.com.livraria.repository.LoginRepository;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@Service
public class LoginServiceBean implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Collection<Login> findAll() {
		 Collection<Login>logins = (Collection<Login>) loginRepository.findAll();
		 return logins;
	}

	@Override
	public Login findOne(Long id) {
		Login login = loginRepository.findOne(id);
		return login;
	}

	@Override
	public Login create(Login login) {
		 if(login.getId()!=null) {
			 return null;
		 }
		 Login savedLogin = loginRepository.save(login);
		 return savedLogin;
		 
	}

	@Override
	public Login update(Login login) {
		 Login loginPersisted = findOne(login.getId());
		 if(loginPersisted == null) {
			 return null;
		 }
		 Login updatedLogin = loginRepository.save(login);
		 return updatedLogin;
		 
	}

	@Override
	public void delete(Long id) {
		loginRepository.delete(id);
		
	}
	
	

}
