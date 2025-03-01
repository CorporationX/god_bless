package bjs2_62563;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock locker = new ReentrantLock();

    public void addPost(@NonNull Post post) {
        locker.lock();

        try {
            posts.add(post);
        } finally {
            locker.unlock();
        }
    }

    public boolean addComment(int postId, @NonNull Comment comment) {
        locker.lock();

        try {
            var post = posts.stream().filter(x -> x.getId() == postId).findFirst();

            if (post.isEmpty()) {
                log.info("Пост #{} не найден", postId);

                return false;
            }

            post.get().getComments().add(comment);
        } finally {
            locker.unlock();
        }

        return true;
    }

    public boolean deletePost(int postId, String author) {
        locker.lock();

        try {
            return posts.removeIf(x -> x.getId() == postId && x.getAuthor().equals(author));
        } finally {
            locker.unlock();
        }
    }

    public boolean deleteComment(int postId, @NonNull String author, LocalDateTime timestamp) {
        locker.lock();

        try {
            var post = posts.stream().filter(x -> x.getId() == postId).findFirst();

            return post.map(value -> value.getComments()
                            .removeIf(x -> x.author().equals(author) && x.timestamp() == timestamp))
                    .orElse(false);
        } finally {
            locker.unlock();
        }
    }

    public void showPosts() {
        locker.lock();

        var stringBuilder = new StringBuilder();
        try {
            for (var post : posts) {
                stringBuilder.append(String.format("%s: %s", post.getAuthor(), post.getTitle()))
                        .append(System.lineSeparator());
                stringBuilder.append(post.getContent()).append(System.lineSeparator());

                for (var comment : post.getComments()) {
                    stringBuilder.append(String.format("\t%s: %s", comment.author(), comment.text()))
                            .append(System.lineSeparator());
                }
            }
        } finally {
            locker.unlock();
        }

        log.info(stringBuilder.toString());
    }
}
