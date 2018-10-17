package com.controller;
import java.io.IOException;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
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
public class BZM_API implements IBZM_API {
	private DAO db = new DAO();
	
	@GetMapping("/getPosts")
	public String getPosts(
			@RequestParam("username") String username, 
			@RequestParam("social_net") String social_net) {
			String result = null;
			SearchHits hits = null;
			try {
				hits =  db.getPosts(username, social_net);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (SearchHit hit : hits.getHits()) {
				    	result.concat(hit.toString());
			}
			return result;
	}
	
	@GetMapping
	public String teste() {
		return "Teste";
	}
	
		
}
	

