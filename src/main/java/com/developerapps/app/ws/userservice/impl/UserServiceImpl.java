package com.developerapps.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.developerapps.app.ws.model.request.UserDetailsRequestModel;
import com.developerapps.app.ws.shared.Utils;
import com.developerapps.app.ws.ui.model.response.UserRest;
import com.developerapps.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;

	private Utils utils;

	@Autowired
	public UserServiceImpl(Utils utils) {
		this.setUtils(utils);
	}

	public UserServiceImpl() {
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {

		UserRest returnvalue = new UserRest();
		returnvalue.setEmail(userDetails.getEmail());
		returnvalue.setFirstName(userDetails.getFirstName());
		returnvalue.setLastName(userDetails.getLastName());

		String userId = getUtils().generateuserId();
		returnvalue.setUserId(userId);
		if (users == null)
			users = new HashMap<String, UserRest>();
		users.put(userId, returnvalue);

		return returnvalue;
	}

	public Utils getUtils() {
		return utils;
	}

	public void setUtils(Utils utils) {
		this.utils = utils;
	}

}
