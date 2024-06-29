package faang.school.godbless.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {
    private ConcurrentHashMap<Long, Post> postById = new ConcurrentHashMap<>();

    public void addComment(Comment comment, Post post) {
        post.addComment(comment);
    }

    public void addPost(Post post) {
        postById.put(post.getId(), post);
    }

    public Map<Long, Post> getAllPosts() {
        return new HashMap<>(postById);
    }
}
