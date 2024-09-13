package com.kodbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.Post;
import com.kodbook.repositories.PostRepository;

@Service
public class PostServiceImplementation implements PostService {

	@Autowired
	PostRepository repo;

	public PostServiceImplementation(PostRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void createPost(Post post) {
		repo.save(post);
	}

	@Override
	public List<Post> fetchAllPost() {
		List<Post> list = repo.findAll();
		return list;
	}
	
	
}
