package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getPosts(
			@RequestParam("username") String username, 
			@RequestParam("social_net") String social_net,
			@RequestParam(value = "order", required = false) String order,
			@RequestParam(value = "limit", required = false) Integer limit) {
		
		 	List<Map> posts = new ArrayList<Map>();
			SearchHits hits = null;
			
		
			/* Se nao fornecido, limite será infinito */
			if (limit == null) {
				limit = -1;
			}
			
			try {
				hits =  db.getPosts(username, social_net, order, limit);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for (SearchHit hit : hits.getHits()) {
				    	String s = hit.toString();
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
	

