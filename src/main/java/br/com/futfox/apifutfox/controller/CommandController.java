package br.com.futfox.apifutfox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="command")
public class CommandController {
	
	@GetMapping
	public String getCommand() {
		return "alert('olá')";
	}
}
