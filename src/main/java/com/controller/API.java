package com.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repository.DAO;
import com.model.Post;

@RestController
@RequestMapping("/bzm_api")
public class API implements IAPI {
	
	private DAO db = new DAO();

	@Override
	public List<Post> getPosts(String user, String social_net) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	

