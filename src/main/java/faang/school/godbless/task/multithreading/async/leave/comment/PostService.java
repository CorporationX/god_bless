package faang.school.godbless.task.multithreading.async.leave.comment;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
public class PostService {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        log.info("Add new post: {}", post);
        posts.put(post.getId(), post);
    }

    public void deletePost(User user, long postId) {
        var post = posts.get(postId);
        if (post != null && isAuthor(user, postId)) {
            post.getPostLock().lock();
            try {
                posts.remove(postId);
                log.info("{} deleted post with id: {}", user.getName(), postId);
            } finally {
                post.getPostLock().unlock();
            }
        } else if (posts.containsKey(postId)) {
            log.info("{}  not author of post with id: {}", user.getName(), postId);
        } else {
            postDontExist(postId);
        }
    }

    private boolean isAuthor(User user, long postId) {
        return posts.get(postId).getAuthor().equals(user);
    }

    public void addComment(long postId, Comment comment) {
        var post = posts.get(postId);
        if (post != null) {
            post.getPostLock().lock();
            try {
                post.addComment(comment);
            } finally {
                post.getPostLock().unlock();
            }
        } else {
            postDontExist(postId);
        }
    }

    public void deleteComment(User user, long postId, Comment comment) {
        var post = posts.get(postId);
        if (post != null) {
            post.getPostLock().lock();
            try {
                post.deleteComment(user, comment.getId());
            } finally {
                post.getPostLock().unlock();
            }
        } else {
            postDontExist(postId);
        }
    }

    private void postDontExist(long postId) {
        log.info("Post with id: {} don't exist", postId);
    }
}
