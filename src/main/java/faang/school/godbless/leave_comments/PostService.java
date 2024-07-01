package faang.school.godbless.leave_comments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PostService {
    private Object lock = new Object();
    @Getter
    private volatile List<Post> posts = new ArrayList<>();

    private Post findById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst().orElseThrow();
    }

    public void addComment(Comment comment, Callable<Integer> postId) {
        synchronized (lock) {
            posts.stream()
                    .filter(post -> {
                        try {
                            return post.getId() == postId.call();
                        } catch (Exception e) {
                            throw new RuntimeException("No post with such id");
                        }
                    })
                    .forEach(post -> post.getComments().add(comment));
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }

    public List<Comment> getComments(Callable<Integer> postId) {
        synchronized (lock) {
            try {
                return findById(postId.call()).getComments();
            } catch (Exception e) {
                throw new RuntimeException("No post with such id");
            }
        }
    }

    public void deletePost(Callable<Integer> postId, String author) {
        synchronized (lock) {
            try {
                Post post = findById(postId.call());
                if (post.getAuthor().equals(author)) {
                    posts.remove(post);
                }
            } catch (Exception e) {
                throw new RuntimeException("No post with such id");
            }
        }
    }

    public void deleteComment(Callable<Integer> postId, Comment comment) {
        synchronized (lock) {
            try {
                Post post = findById(postId.call());
                Comment commentToDelete = post.getComments().stream()
                        .filter(comm -> comm.getAuthor().equals(comment.getAuthor()) && comm.getText().equals(comment.getText()))
                        .findAny()
                        .orElseThrow();
                post.getComments().remove(commentToDelete);
            } catch (Exception e) {
                throw new RuntimeException("No post with such id");
            }
        }
    }
}
