package school.faang.task421.post;

import school.faang.task421.comment.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class PostService {
    private List<Post> posts = new ArrayList<>();
    private Lock lock = new ReentrantLock();

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
            posts.get(postId).getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void printAllPost() {
        lock.lock();
        try {
            posts.forEach(post -> {
                System.out.println(post.getAuthor() + " " + post.getTitle() + " " + post.getContent());
                printAllComment(post);
            });
        } finally {
            lock.unlock();
        }
    }

    private void printAllComment(Post post) {
        lock.lock();
        try {
            System.out.println("Комментарии к посту " + post.getTitle());
            post.getComments().forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(String author, int postId) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(comment -> comment.getAuthor().equals(author));
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(String author, int postId) {
        lock.lock();
        try {
            posts = posts.stream()
                    .filter(post -> !(post.getId() == postId && post.getAuthor().equals(author))) // Фильтруем посты
                    .collect(Collectors.toList());
        } finally {
            lock.unlock();
        }
    }
}
