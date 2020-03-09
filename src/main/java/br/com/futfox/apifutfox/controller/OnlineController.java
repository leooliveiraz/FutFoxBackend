package br.com.futfox.apifutfox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futfox.apifutfox.dto.Online;

@RestController
@RequestMapping(path="online")
public class OnlineController {

	@GetMapping
	public Online isOnline() {
		return new Online();
	}
}
