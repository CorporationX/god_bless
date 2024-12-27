package school.faang.task_51193;

import lombok.NonNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {
    private final Map<UUID, Post> posts = new ConcurrentHashMap<>();

    public Post getPost(@NonNull UUID postId) {
        return posts.get(postId);
    }

    public void addPost(@NonNull Post post) {
        posts.put(post.getId(), post);
    }

    public void deletePost(@NonNull UUID postId) {
        posts.remove(postId);
    }

    public Comment getComment(@NonNull UUID postId, @NonNull UUID commentId) {
        return posts.get(postId).getComment(commentId);
    }

    public void addComment(@NonNull UUID postId, @NonNull Comment comment) {
        posts.get(postId).addComment(comment);
    }

    public void deleteComment(@NonNull UUID postId, @NonNull UUID commentId) {
        posts.get(postId).deleteComment(commentId);
    }
}