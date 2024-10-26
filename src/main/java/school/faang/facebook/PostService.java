package school.faang.facebook;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    @Getter
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("New Post added: " + post.getId());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.stream().filter(post -> post.getId() == postId).findFirst()
                    .ifPresent(post -> post.addComment(comment));
            System.out.println("Comment added : " + comment.getText());
        } finally {
            lock.unlock();
        }
    }

    public void readPost(int id) {
        lock.lock();
        try {
            Optional<Post> first = posts.stream().filter(post -> post.getId() == id).findFirst();
            first.ifPresentOrElse(post -> System.out.println("Reading post with id = " + id + ", POST: " + post),
                    () -> System.out.println("Post with id = " + id + " was not found"));
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int id, String author) {
        lock.lock();
        try {
            boolean isRemoved = posts.removeIf(post -> post.getId() == id && post.getAuthor().equals(author));
            if (isRemoved) {
                System.out.println("Post with id = " + id + " has been removed");
            } else {
                System.out.println("Post with id = " + id + " has not been found");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int id, String author) {
        lock.lock();
        boolean isRemoved;
        try {
            for (Post post : posts) {
                if (post.getId() == id) {
                    isRemoved = post.getComments().removeIf(comment -> comment.getAuthor().equals(author));
                    if (isRemoved) {
                        System.out.println("Comment for Post with id = " + id + " and Author = " + author + " has been removed");
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
