package faang.school.godbless.BJS2_25597;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostService {
    private Object lockComments = new Object();
    private Object lockPost = new Object();
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(Comment comment, int id) {
        synchronized (lockComments) {
            posts.get(id).getComments().add(comment);
        }
    }

    public void addPost(Post post) {
        synchronized (lockPost) {
            posts.add(post);
        }
    }
}
