package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class PostService implements Runnable {

    private CopyOnWriteArrayList<Post> listPosts;
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

    public void addComment(CopyOnWriteArrayList<Post> listPosts, Comment comment) {
        lock.lock();
        try {
            listPosts.stream()
                    .filter(w -> comment.getPostID() == w.getPostID())
                    .findAny()
                    .map(p -> p.getListComments().add(comment));
        } finally {
            lock.unlock();
        }
    }

    public void addPost(CopyOnWriteArrayList<Post> listPosts, Post post) {
        listPosts.add(post);
    }
}
