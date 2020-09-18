package com.developerapps.app.ws.userservice;

import com.developerapps.app.ws.model.request.UserDetailsRequestModel;
import com.developerapps.app.ws.ui.model.response.UserRest;


public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);

}
