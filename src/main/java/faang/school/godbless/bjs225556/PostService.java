package faang.school.godbless.bjs225556;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Data
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Object lock = new Object();

    public void addComment(int postId, Comment comment) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock) {
            findPostById(postId)
                    .ifPresentOrElse(
                            post -> post
                                    .getComments()
                                    .add(comment),
                            () -> {
                                throw new NoSuchElementException("Post with ID " + postId + " not found.");
                            });
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }

    public void showPost(int postId) {
        findPostById(postId)
                .ifPresentOrElse(
                        post -> {
                            System.out.println("Author: " + post.getUser().getName());
                            System.out.println("Text: " + post.getText());
                            System.out.println("Comments: ");
                            for (var comment : post.getComments()) {
                                System.out.println(comment.getUser().getName()
                                        + ": "
                                        + comment.getText());
                            }
                        },
                        () -> {
                            throw new NoSuchElementException("Post with ID " + postId + " not found.");
                        }
                );
    }

    public void deletePost(int postId, User user) {
        synchronized (lock) {
            findPostById(postId)
                    .ifPresentOrElse(
                            post -> {
                                if (post.getUser().equals(user)) {
                                    posts.remove(post);
                                } else {
                                    throw new SecurityException("User does not have permission to delete this post.");
                                }
                            },
                            () -> {
                                throw new NoSuchElementException("Post with ID " + postId + " not found.");
                            }
                    );
        }
    }

    public void deleteComment(int postId, int commentId, User user) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (lock) {
            findPostById(postId)
                    .ifPresentOrElse(
                            post -> findCommentById(commentId, post)
                                    .ifPresentOrElse(
                                            comment -> {
                                                if (comment.getUser().equals(user)) {
                                                    post.getComments().remove(comment);
                                                } else {
                                                    throw new SecurityException("User does not have permission to delete this comment.");
                                                }
                                            },
                                            () -> {
                                                throw new NoSuchElementException("Comment with ID " + postId + " not found.");
                                            }
                                    ),
                            () -> {
                                throw new NoSuchElementException("Post with ID " + postId + " not found.");
                            }
                    );
        }
    }


    private Optional<Post> findPostById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    private Optional<Comment> findCommentById(int commentId, Post post) {
        return post.getComments()
                .stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst();
    }
}
