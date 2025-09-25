package school.faang.bjs2_93666;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();

    public void addPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Пост не может быть null");
        }
        try {
            lock.lock();
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        isValidatesId(postId);
        if (comment == null) {
            throw new IllegalArgumentException("Id поста не может быть меньше 0. Комментарий не может быть пустым");
        }
        try {
            lock.lock();
            posts.get(postId).getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public Post getPost(int postId) {
        isValidatesId(postId);
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("По такому id поста нет!"));
    }

    public String getComment(int postId) {
        isValidatesId(postId);
        return getPost(postId).getComments().stream()
                .map(comment -> "%s - Пользователь, %s - текст, %s - время написания".formatted(
                        comment.getAuthor(), comment.getText(), comment.getTimestamp())).toString();

    }

    public void removePost(int postId) {
        isValidatesId(postId);
        try {
            lock.lock();
            posts.stream()
                    .map(post -> {
                        if (post.getId() == postId) {
                            posts.remove(post);
                            log.info("Пост удален!");
                            return true;
                        }
                        log.info("Такого поста не существует!");
                        return false;
                    });
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId) {

    }

    private void isValidatesId(int number) {
        if (number < 0) {
            log.error("Валидация на Id не прошла");
            throw new IllegalArgumentException("Id не может быть меньше 0");
        }
    }
}
