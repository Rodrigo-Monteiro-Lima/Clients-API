package com.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algalog.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> list() {
		
		Client client1 = new Client();
		client1.setId(1L);
		client1.setName("Rodrigo");
		client1.setCellphone("75 9 8888-8888");
		client1.setEmail("rodrigo@test.com");
		
		Client client2 = new Client();
		client2.setId(2L);
		client2.setName("Daniel");
		client2.setCellphone("75 9 9191-8888");
		client2.setEmail("daniel@test.com");
		
		return Arrays.asList(client1, client2);
	}
}
