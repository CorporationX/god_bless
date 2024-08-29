package commenting;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Map<Post, Object> postLocks = new HashMap<>();

    public synchronized int addPost(@NonNull Post post) {
        if (!postLocks.containsKey(post)) {
            posts.add(post);
            postLocks.put(post, new Object());

            return posts.size() - 1;
        } else {
            throw new IllegalArgumentException("Posts already in service");
        }
    }

    public void addComment(@NonNull Comment comment, int id) {
        if (id > posts.size()) {
            throw new IllegalArgumentException("Don't have post with this id!");
        }
        synchronized (postLocks.get(posts.get(id))) {
            posts.get(id).getComments().add(comment);
        }
    }
}
