package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.ParseException;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repository.DAO;

@RestController
@RequestMapping("/bzm_api")
public class BZM_API implements IBZM_API {
	private DAO db = new DAO();
	
	@GetMapping("/getPosts")
	public ResponseEntity<Object> getPosts(
			@RequestParam("username") String username, 
			@RequestParam("social_net") String social_net,
			@RequestParam(value = "order", defaultValue = "ASC") String order,
			@RequestParam(value = "limit", defaultValue = "-1") Integer limit) {
		
		 	List<Map> posts = new ArrayList<Map>();
			
		 	SearchHits hits = null;
						
			try {
				hits =  db.getPosts(username, social_net, order, limit);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for (SearchHit hit : hits.getHits()) {
				    	Map<String, Object> hitAsMap = hit.getSourceAsMap();
				    	posts.add(hitAsMap);
			}
			
			return new ResponseEntity<Object>(posts, HttpStatus.OK);
	}
	
	@GetMapping
	public String teste() {
		return "Teste";
	}
	
		
}
	

