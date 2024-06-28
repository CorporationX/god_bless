package faang.school.godbless.leave_comments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private Object lock = new Object();
    @Getter
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(Comment comment, int postId) {
        synchronized (lock) {
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .forEach(post -> post.getComments().add(comment));
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }
}
