package school.faang.task_51182;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PostService {
    private final Map<UUID, Post> posts = new ConcurrentHashMap<>();

    public Post getPost(@NonNull UUID postId) {
        return Optional.ofNullable(posts.get(postId))
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + postId));
    }

    public void addPost(@NonNull Post post) {
        posts.put(post.getId(), post);
        log.info("Post added: {}", post);
    }

    public void deletePost(@NonNull UUID postId) {
        posts.remove(postId);
        log.info("Post deleted with ID: {}", postId);
    }

    public Comment getComment(@NonNull UUID postId, @NonNull UUID commentId) {
        return Optional.ofNullable(getPost(postId).getComment(commentId))
                .orElseThrow(() -> new IllegalArgumentException("Comment not found: " + commentId));
    }

    public void addComment(@NonNull UUID postId, @NonNull Comment comment) {
        getPost(postId).addComment(comment);
        log.info("Comment added: {}", comment);
    }

    public void deleteComment(@NonNull UUID postId, @NonNull UUID commentId) {
        getPost(postId).deleteComment(commentId);
        log.info("Comment deleted with ID: {}", commentId);
    }
}