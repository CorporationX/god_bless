package faang.school.godbless.Comments;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final Lock lock = new ReentrantLock();
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(int postId, Comment comment) {
        if (comment == null) {
            return;
        }

        lock.lock();
        try {
            Optional<Post> found = posts.stream().filter(post -> post.getId() == postId).findAny();
            if (found.isPresent()) {
                found.get().addComment(comment);
                log.info("{} added to post {}", comment.getAuthor(), postId);
            } else {
                log.error("can't add comment {} to postId {} because postId does not exists", comment.getText(), postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        if (post == null) {
            return;
        }

        lock.lock();
        try {
            posts.add(post);
            log.info("post {} added", post.getHeader());
        } finally {
            lock.unlock();
        }
    }

    public void removePost(Post post, String user) {
        if (post == null) {
            return;
        }

        lock.lock();
        try {
            Optional<Post> found = posts.stream().filter(o -> o.getId() == post.getId()).findAny();
            if (found.isPresent()) {
                if (found.get().getAuthor().equals(user)) {
                    posts.remove(post);
                    log.info("post {} removed", post.getHeader());
                } else {
                    log.error("post {} with author {} can't be removed by user {}", post.getHeader(), post.getAuthor(), user);
                }
            } else {
                log.error("post with postId {} not found", post.getId());
            }
        } finally {
            lock.unlock();
        }
    }

    public void printPosts() {
        if (posts.isEmpty()) {
            return;
        }

        lock.lock();
        try {
            final StringBuilder builder = new StringBuilder();
            posts.forEach(post -> builder.append(post.getHeader()).append(" | "));
            log.info(builder.toString());
        } finally {
            lock.unlock();
        }
    }

    public void printPostsComments() {
        if (posts.isEmpty()) {
            return;
        }

        lock.lock();
        try {
            posts.forEach(post -> {
                final StringBuilder builder = new StringBuilder();
                builder.append(post.getHeader()).append(" -> ");
                post.getComments().forEach(comment -> builder.append(comment.getText()).append(" | "));
                log.info(builder.toString());
            });
        } finally {
            lock.unlock();
        }
    }
}
