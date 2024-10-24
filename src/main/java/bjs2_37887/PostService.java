package bjs2_37887;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final Lock lock = new ReentrantLock();
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> postById = searchPostById(postId);
            postById.ifPresentOrElse(post -> post.getComments().add(comment),
                    () -> System.out.println("Post not found"));
        } finally {
            lock.unlock();
        }
    }

    public void viewPosts() {
        lock.lock();
        try {
            posts.forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }

    public void viewComments(int postId) {
        lock.lock();
        try {
            Optional<Post> postById = searchPostById(postId);
            postById.ifPresentOrElse(post -> post.getComments().forEach(System.out::println),
                    () -> System.out.println("Post not found"));
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            Optional<Post> postById = searchPostById(postId);
            postById.ifPresentOrElse(post -> {
                        if (post.getAuthor().equals(author)) {
                            posts.remove(post);
                        } else {
                            System.out.println("Only author can delete the post");
                        }
                    },
                    () -> System.out.println("Post not found"));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            Optional<Post> postById = searchPostById(postId);
            postById.ifPresentOrElse(post -> {
                if (comment.getAuthor().equals(author)) {
                    post.getComments().remove(comment);
                } else {
                    System.out.println("Only author can delete the comment");
                }                    },
                    () -> System.out.println("Post not found"));
        } finally {
            lock.unlock();
        }
    }

    private Optional<Post> searchPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findAny();
    }
}
