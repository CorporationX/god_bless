package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostService extends Thread {

    volatile List<Post> posts;
    private Post post;
    private Comment comment;

    @Override
    public void run() {
        if(comment == null) {
            addPost(posts, post);
        } else {
            addComment(posts, comment);
        }
    }

    public void addComment(List<Post> posts, Comment comment) {
        synchronized (posts) {
            posts.stream()
                    .filter(w -> comment.getId() == w.getId())
                    .findAny()
                    .map(p -> p.getListComments().add(comment))
                    .orElse(null);
        }
    }

    public void addPost(List<Post> posts, Post post) {
        synchronized (posts) {
            posts.add(post);
        }
    }
}
