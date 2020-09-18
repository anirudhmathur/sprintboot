package com.developerapps.app.ws.shared;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Utils {
	
	public Utils() {};
	public String generateuserId() {
		return UUID.randomUUID().toString();
	}

}
