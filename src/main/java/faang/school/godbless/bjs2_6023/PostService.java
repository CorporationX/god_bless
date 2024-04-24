package faang.school.godbless.bjs2_6023;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void removeCommentFromPost(long postId, long commentId, String user) {
        lock.lock();
        try {
            Optional<Post> foundPost = findPostById(postId);
            if (foundPost.isPresent()) {
                //find comment
                Optional<Comment> foundComment = foundPost.get().getComments().stream()
                        .filter(comment -> comment.getId() == commentId)
                        .findFirst();
                if (foundComment.isPresent()) {
                    if (user.equals(foundComment.get().getAuthor())) {
                        foundPost.get().getComments().remove(foundComment.get());
                        log.info("Comment with ID: {} was deleted", commentId);
                    } else {
                        log.warn("{} is not the author of the comment. Removal is prohibited!", user);
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void removePost(long postId, String user) {
        lock.lock();
        try {
            Optional<Post> foundPost = findPostById(postId);
            if (foundPost.isPresent()) {
                if (user.equals(foundPost.get().getAuthor())){
                    posts.remove(foundPost.get());
                    log.info("Post with ID: {} was deleted", postId);
                } else {
                    log.warn("{} is not the author of the post. Removal is prohibited!", user);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printPost(long postId) {
        Optional<Post> foundPost = findPostById(postId);
        foundPost.ifPresent(System.out::println);
    }

    public void addComment(long postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> foundPost = findPostById(postId);
            foundPost.ifPresent(post -> post.getComments().add(comment));
            log.info("Add comment: {}", comment.getText());
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            log.info("Post with id {} was added", post.getId());
        } finally {
            lock.unlock();
        }
    }

    //Print comments for post
    public void printCommentForPost(long postId) {
        lock.lock();
        try {
            log.info("Comments for post with ID: {}", postId);
            Optional<Post> foundPost = findPostById(postId);
            foundPost.ifPresent(post -> post.getComments()
                    .forEach(System.out::println));
        } finally {
            lock.unlock();
        }
    }

    public Optional<Post> findPostById(long postId) {
        lock.lock();
        try {
            Optional<Post> foundPost = posts.stream().filter(p -> p.getId() == postId).findFirst();
            if (foundPost.isEmpty()) {
                log.warn("Post with ID: {} not found", postId);
            }
            return foundPost;
        } finally {
            lock.unlock();
        }
    }
}
