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
        if(post.isDeleted()) {
            post.reinstate();
        }
        posts.put(post.getId(), post);
    }

    public void deletePost(User user, long postId) {
        if (posts.containsKey(postId)) {
            var post = posts.get(postId);
            synchronized (post) {
                if (user.equals(post.getAuthor())) {
                    post.markPostAsDelete();
                    log.info("{} deleted post with id: {}", user.getName(), postId);
                } else {
                    log.info("{} isn't author of post with id: {}", user.getName(), postId);
                }
            }
        } else {
            postDontExist(postId);
        }
    }

    public void addComment(long postId, Comment comment) {
        if (posts.containsKey(postId)) {
            var post = posts.get(postId);
            synchronized (post) {
                if (!post.isDeleted()) {
                    post.addComment(comment);
                } else {
                    postDeleted(postId);
                }
            }
        } else {
            postDontExist(postId);
        }
    }

    public void deleteComment(User user, long postId, Comment comment) {
        if (posts.containsKey(postId)) {
            var post = posts.get(postId);
            synchronized (post) {
                if (!post.isDeleted()) {
                    post.deleteComment(user, comment.getId());
                } else {
                    postDeleted(postId);
                }
            }
        } else {
            postDontExist(postId);
        }
    }

    private void postDontExist(long postId) {
        log.info("Post with id: {} don't exist", postId);
    }

    private void postDeleted(long postId) {
        log.info("Post with id {} deleted", postId);
    }
}
