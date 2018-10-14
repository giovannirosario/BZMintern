package com.controller;
import java.util.List;

import com.model.Post;


public interface IAPI {
	public List<Post> getPosts(String user, String social_net);
}