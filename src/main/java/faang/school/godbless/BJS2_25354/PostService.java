package faang.school.godbless.BJS2_25354;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private final List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        synchronized (posts) {
            posts.add(post);
        }
    }

    public void addComment(int postId, Comment comment) {
        synchronized (posts) {
            if (postId >= 0 && postId < posts.size()) {
                posts.get(postId).addComment(comment);
            }
        }
    }

    public List<Post> getPosts() {
        synchronized (posts) {
            return new ArrayList<>(posts);
        }
    }
}