package br.com.futfox.apifutfox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futfox.apifutfox.entity.Account;
import br.com.futfox.apifutfox.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accRepository;

	public Account findByUsernameAndPassword(String username, String password) {
		Account acc = accRepository.findByUsernameAndPassword(username, password);
		return acc;
	}

	public Account findByUsername(String username) {
		Account acc = accRepository.findByUsername(username);
		return acc;
	}

}
