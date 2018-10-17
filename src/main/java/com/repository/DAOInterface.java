package com.repository;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.search.SearchHits;

import com.model.Post;

public interface DAOInterface {
	public SearchHits getPosts(String user, String social_net);
}
