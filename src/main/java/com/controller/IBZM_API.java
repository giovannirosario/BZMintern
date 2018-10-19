package com.controller;
import org.springframework.http.ResponseEntity;

public interface IBZM_API {
	public ResponseEntity<Object> getPosts(String user, String social_net, String order, Integer limit);
}