package ru.kraiush.threads.BJS2_25625;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostService extends Thread {

    private List<Post> commonAccess;
    private Post post;
    private Comment comment;

    @Override
    public void run() {
        if(comment == null) {
            addPost(commonAccess, post);
        } else {
            addComment(commonAccess, comment);
        }
    }

    public void addComment(List<Post> commonAccess, Comment comment) {
        synchronized (commonAccess) {
            commonAccess.stream()
                    .filter(w -> comment.getId() == w.getId())
                    .findAny()
                    .map(p -> p.getListComments().add(comment))
                    .orElse(null);
        }
    }

    public void addPost(List<Post> commonAccess, Post post) {
        synchronized (commonAccess) {
            commonAccess.add(post);
        }
    }
}
