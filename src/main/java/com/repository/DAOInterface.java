package com.repository;

import org.elasticsearch.search.SearchHits;

public interface DAOInterface {
	public SearchHits getPosts(String user, String social_net, String order, Integer limit);
}
