package faang.school.godbless.BJS2_1382;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();

    public synchronized boolean addComment(Post post, Comment comment) {
        Post existingPost = posts.get(post.getId());

        if (existingPost != null) {
            existingPost.addComment(comment);
            return true;
        }
        return false;
    }

    public synchronized void addPost(Post post) {
        posts.put(post.getId(), post);
    }
}