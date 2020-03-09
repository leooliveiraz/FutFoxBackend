package br.com.futfox.apifutfox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futfox.apifutfox.entity.Command;
import br.com.futfox.apifutfox.repository.CommandRepository;

@Service
public class CommandService {
	@Autowired
	private CommandRepository comRepository;
	
	public Command findFirstCommandByUser(Integer id, Boolean done) {
		Command command = comRepository.findTopByAccountIdAndDoneOrderByIdAsc(id, done);
		return command;
	}

	
	public void update(Command command) {
		comRepository.save(command);		
	}

}
