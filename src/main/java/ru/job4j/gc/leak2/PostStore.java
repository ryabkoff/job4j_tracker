package ru.job4j.gc.leak2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    private static Map<Integer, Post> posts = new HashMap<>();

    public AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        Integer id = atomicInteger.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public static Collection<Post> getPosts() {
        return posts.values();
    }
}