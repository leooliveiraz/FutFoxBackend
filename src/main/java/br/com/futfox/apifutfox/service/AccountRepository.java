package br.com.futfox.apifutfox.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.futfox.apifutfox.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	public Account findByUsernameAndPassword(String username, String password);
}
