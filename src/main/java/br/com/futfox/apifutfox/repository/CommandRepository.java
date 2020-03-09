package br.com.futfox.apifutfox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.futfox.apifutfox.entity.Command;

@Repository
public interface CommandRepository extends CrudRepository<Command, Long> {
	public Command findByAccountIdAndDone(Long id, Boolean done);

	public Command findTopByAccountIdAndDoneOrderByIdAsc(Integer id, Boolean done);
}
