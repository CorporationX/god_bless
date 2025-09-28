package school.faang.bjs2_93666;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Пост не может быть null");
        }
        try {
            lock.lock();
            boolean postExists = posts.stream().anyMatch(posts -> posts.getId() == post.getId());
            if (postExists) {
                log.warn("Пост с ID {} уже существует. Пропускаем добавление.", post.getId());
                return;
            }
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        isValidatesId(postId);
        isValidatesComment(comment);
        try {
            lock.lock();
            Post post = getPost(postId);
            log.info("{} - Комментарий был добавлен в пост {}", comment.getText(), post.getTitle());
            post.getComments().add(comment);
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

    public List<Comment> getComment(int postId) {
        isValidatesId(postId);
        return getPost(postId).getComments();
    }

    public void removePost(int postId) {
        isValidatesId(postId);
        try {
            lock.lock();
            if (isTrustAuthorPost(postId)) {
                log.info("Ваш пост {} удален!", getPost(postId).getTitle());
                posts.stream()
                        .filter(post -> post.getId() == postId)
                        .findFirst()
                        .map(posts::remove);
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId) {
        try {
            lock.lock();
            getComment(postId).removeIf(comment -> {
                if (isTrustAuthorComment(comment)) {
                    log.info("{} - Вы удалили свой комментарий! {}", comment.getAuthor(), comment.getText());
                    return true;
                }
                return false;
            });
        } finally {
            lock.unlock();
        }
    }

    private void isValidatesId(int number) {
        if (number < 0) {
            log.error("Валидация на Id не прошла");
            throw new IllegalArgumentException("Id не может быть меньше 0");
        }
    }

    private void isValidatesComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Id поста не может быть меньше 0. Комментарий не может быть пустым");
        }
    }

    private boolean isTrustAuthorPost(int postId) {
        Post post = this.getPost(postId);
        if (!post.getAuthor().equals(Thread.currentThread().getName())) {
            log.info("Вы не автор данного поста! Удаление невозможно");
        }
        return true;
    }

    private boolean isTrustAuthorComment(Comment comment) {
        return comment.getAuthor().equals(Thread.currentThread().getName());
    }
}
