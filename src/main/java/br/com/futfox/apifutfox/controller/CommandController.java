package br.com.futfox.apifutfox.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futfox.apifutfox.entity.Account;
import br.com.futfox.apifutfox.entity.Command;
import br.com.futfox.apifutfox.service.AccountService;
import br.com.futfox.apifutfox.service.CommandService;

@RestController
@RequestMapping(path="command")
public class CommandController {
	@Autowired
	private AccountService accService;
	@Autowired 
	private CommandService commandService;
	
	@GetMapping
	public String getCommand(Principal principal) {
		if(null != principal && null != principal.getName() && !principal.getName().isEmpty()) {
			Account account = accService.findByUsername(principal.getName());
			if(null != account) {
				try {
					Command command = commandService.findFirstCommandByUser(account.getId(), false);
					command.setDone(true);
					commandService.update(command);
					return command.getCommand();
				} catch (Exception e) {
					System.out.println("No Command");
				}
			}
		}
		return ""; 
	}
}
