package br.com.futfox.apifutfox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="online")
public class OnlineController {

	@GetMapping
	public Boolean isOnline() {
		return true;
	}
}
