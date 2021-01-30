package org.example.repository;


import org.example.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepository {

    private final Map<Long, Post> posts;

    public PostRepository() {
        this.posts = new ConcurrentHashMap<>();
    }

    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(posts.get(id));
    }

    public Post save(Post post) {
        posts.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}
