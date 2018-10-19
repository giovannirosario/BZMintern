package com.controller;
import java.util.List;

import org.apache.http.HttpEntity;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.springframework.http.ResponseEntity;

import com.model.Post;


public interface IBZM_API {
	public ResponseEntity<Object> getPosts(String user, String social_net, String order, Integer limit);
}