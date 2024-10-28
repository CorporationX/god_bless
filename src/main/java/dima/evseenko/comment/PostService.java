package dima.evseenko.comment;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final Object postsLock = new Object();

    public void addPost(@NotNull Post post) {
        synchronized (postsLock) {
            posts.put(post.getId(), post);
        }
    }

    public void addComment(int postId, @NotNull Comment comment) {
        synchronized (postsLock) {
            if (posts.containsKey(postId)) {
                posts.get(postId).getComments().put(comment.getId(), comment);
            }
        }
    }

    public void deletePost(int postId) {
        synchronized (postsLock) {
            posts.remove(postId);
        }
    }

    public void deleteComment(int postId, int commentId) {
        synchronized (postsLock) {
            if (posts.containsKey(postId)) {
                posts.get(postId).getComments().remove(commentId);
            }
        }
    }

    public void printPosts() {
        posts.forEach((postId, post) -> System.out.println(post));
        System.out.println();
    }

    public void printComments(int postId) {
        if (posts.containsKey(postId)) {
            posts.get(postId).getComments().forEach((commentId, comment) -> System.out.println(comment));
            System.out.println();
        }
    }
}
