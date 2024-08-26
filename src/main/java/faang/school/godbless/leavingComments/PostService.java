package faang.school.godbless.leavingComments;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class PostService {
    private final List<Post> posts = new LinkedList<>();
    private final Object lock = new Object();

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }

    public void addComment(Comment comment, int postId) {
        synchronized (lock) {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().add(comment);
                }
            }
        }
    }

    public void deletePost(int postId) {
        synchronized (lock) {
            posts.removeIf(post ->
                    post.getId() == postId && post.getAuthorName().equals(Thread.currentThread().getName()));
        }
    }

    public void deleteComment(int postId, int commentId) {
        synchronized (lock) {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().stream()
                            .filter(comment -> comment.getId() == commentId)
                            .findFirst()
                            .ifPresent(comment -> {
                                if (comment.getAuthorName().equals(Thread.currentThread().getName())) {
                                    post.getComments().remove(comment);
                                } else {
                                    System.out.println("No comments with id " + commentId + " found for post with id " + postId);
                                }
                            });
                }
            }
        }
    }
}
