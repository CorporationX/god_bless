package school.faang.bjs2_93607;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        posts.add(post);
        lock.unlock();
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        Optional<Post> postOp = posts.stream()
                .filter(post -> Objects.equals(post.getId(), postId))
                .reduce((p1, p2) -> p1);
        postOp.ifPresent(post -> post.addComments(comment));
        lock.unlock();

    }

    public Post getPostAndComments(int postId) {
        Optional<Post> postOp = posts.stream()
                .filter(post -> Objects.equals(post.getId(), postId))
                .reduce((p1, p2) -> p1);
        if (postOp.isPresent()) {
            Post post = postOp.get();
            printPost(post);
            return post;
        } else {
            log.info("Поста с таким Id {} нет", postId);
            Thread.currentThread().interrupt();
            throw new NullPointerException();
        }
    }

    public void removePost(int postId) {
        lock.lock();
        posts.removeIf(post -> Objects.equals(postId, post.getId()));
        lock.unlock();
    }

    public void removeComment(int postId, Author author, String text) {
        Optional<Post> postOp = searchPost(postId);
        List<Comment> listForRemove = new ArrayList<>();
        if (postOp.isPresent()) {
            Post post = postOp.get();
            post.getComments().stream()
                    .forEach(comment -> {
                        if (Objects.equals(comment.getText(), text)
                                && Objects.equals(comment.getAuthor(), author)) {
                            listForRemove.add(comment);
                        }
                    });
            post.removeComments(listForRemove, post.getAuthor());
        } else {
            throw new RuntimeException();
        }
    }

    private void printPost(Post post) {
        log.info("Пост - {}, \n Автор - {}, \n Текст - {}\n, Коментарии -{}",
                post.getTitle(), post.getAuthor(), post.getText(),
                post.getComments());
    }

    private Optional<Post> searchPost(int postId) {
        return posts.stream()
                .filter(post -> Objects.equals(post.getId(), postId))
                .reduce((p1, p2) -> p1);
    }
}
