package school.faang.task_51253;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

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
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().add(comment);
                } else {
                    log.warn("Пост с id {} не найден", postId);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(Comment comment, Post post, String author) {
        if (comment.getAuthor().equals(author)) {
            post.getComments().remove(comment);
            System.out.println("Комментарий автора " + comment.getAuthor() + " удален");
        } else {
            log.warn("Невозможно удалить чужой комментарий");
        }
    }

    public void deletePost(Post postForDelite, String author) {
        if (postForDelite.getAuthor().equals(author)) {
            posts.stream().filter(post -> post.equals(postForDelite)).findFirst().ifPresentOrElse(post ->
                    posts.remove(post), () -> log.warn("Пост {} не найден", postForDelite.getId()));
            System.out.println("Пост автора " + postForDelite.getAuthor() + " удален");
        } else {
            log.warn("Вы не можете удалить пост. Его автор {}", postForDelite.getAuthor());
        }
    }

    public void viewComment(Post post) {
        for (Comment comment : post.getComments()) {
            System.out.println(comment);
        }
    }

    public void viewPost(Post post) {
        System.out.println(post);
    }
}
