package br.com.futfox.apifutfox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.futfox.apifutfox.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	public Account findByUsernameAndPassword(String username, String password);

	public Account findByUsername(String username);
}
