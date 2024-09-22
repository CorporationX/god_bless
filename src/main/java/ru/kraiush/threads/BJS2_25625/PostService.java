package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class PostService implements Runnable {

    private volatile List<Post> listPosts;
    private Post post;
    private Comment comment;
    private Lock lock;

    @Override
    public void run() {
        if (comment == null) {
            addPost(listPosts, post);
        } else {
            addComment(listPosts, comment);
        }
    }

    public void addComment(List<Post> listPosts, Comment comment) {
            listPosts.stream()
                    .filter(w -> comment.getId() == w.getPostID())
                    .findAny()
                    .map(p -> p.getListComments().add(comment));
    }

    public void addPost(List<Post> listPosts, Post post) {
        lock.lock();
        try {
            listPosts.add(post);
        } finally {
            lock.unlock();
        }
    }
}
