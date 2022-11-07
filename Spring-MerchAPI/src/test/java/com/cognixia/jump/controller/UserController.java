package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserController {

	
	
	
	@Autowired
	MockMvc mockmvc;
	
	
	
	
	@MockBean
	UserRepository userrepo;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
