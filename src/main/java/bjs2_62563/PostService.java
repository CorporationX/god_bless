package bjs2_62563;

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

    public void addPost(Post post) {
        locker.lock();

        try {
            posts.add(post);
        } finally {
            locker.unlock();
        }
    }

    public boolean addComment(int postId, Comment comment) {
        locker.lock();

        try {
            var post = posts.stream().filter(x -> x.getId() == postId).findFirst();

            if (post.isEmpty()) {
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

    public boolean deleteComment(int postId, String author, LocalDateTime timestamp) {
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

        try {
            for (var post : posts) {
                log.info("{}: {}", post.getAuthor(), post.getTitle());
                log.info(post.getContent());

                for (var comment : post.getComments()) {
                    log.info("     {}: {}", comment.author(), comment.text());
                }
            }
        } finally {
            locker.unlock();
        }
    }
}
