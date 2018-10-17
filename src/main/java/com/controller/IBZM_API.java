package com.controller;
import java.util.List;

import org.apache.http.HttpEntity;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;

import com.model.Post;


public interface IBZM_API {
	public String getPosts(String user, String social_net);
}