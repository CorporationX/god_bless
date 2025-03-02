package bjs262572;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writePostLock = lock.writeLock();
    private final Lock readPostLock = lock.readLock();

    public void addPost(@NonNull Post post) {
        try {
            writePostLock.lock();
            log.info("Posts list size is {} before the post {} has added", posts.size(), post);
            log.info("Thread {} adding post {}", Thread.currentThread().getName(), post);
            posts.add(post);
            log.info("Posts list size is {} after the post {} has added", posts.size(), post);
        } finally {
            writePostLock.unlock();
        }
    }

    public Post getPost(int postId) {
        try {
            readPostLock.lock();
            return Optional.ofNullable(posts.get(postId))
                    .orElseThrow(() -> new IllegalArgumentException("Post id can not be null"));
        } finally {
            readPostLock.unlock();
        }
    }

    public void removePost(int postId, String author) {
        try {
            writePostLock.lock();
            posts.removeIf(post -> postId != 0 && posts.contains(getPost(postId))
                    && Objects.requireNonNull(post.getAuthor()).equals(author));
        } finally {
            writePostLock.unlock();
        }
    }

    public void addComment(int postId, @NonNull Comment comment) {
        try {
            writePostLock.lock();
            log.info("Comments list size is {} before comment {} has added in the post {}",
                    getPost(postId).getComments().size(), comment, getPost(postId));
            log.info("Thread {} adding comment {}", Thread.currentThread().getName(), comment);
            getPost(postId).getComments().add(comment);
            log.info("Comments list size is {} after comment {} has added in the post {}",
                    getPost(postId).getComments().size(), comment, getPost(postId));
        } finally {
            writePostLock.unlock();
        }
    }

    public Comment getComment(int postId, int commentId) {
        try {
            readPostLock.lock();
            return posts.stream()
                    .filter(post -> getPost(postId).getId() == postId && commentId != 0
                            && Objects.nonNull(post.getComments().get(commentId)))
                    .map(post -> post.getComments().get(commentId))
                    .toList().get(0);
        } finally {
            readPostLock.unlock();
        }
    }

    public void removeComment(int postId, LocalDateTime timeStamp, String author) {
        try {
            writePostLock.lock();
            getPost(postId).getComments().removeIf(comment -> getPost(postId).getId() == postId
                    && comment.getTimeStamp().equals(timeStamp)
                    && comment.getAuthor().equals(author));
        } finally {
            writePostLock.unlock();
        }
    }
}
