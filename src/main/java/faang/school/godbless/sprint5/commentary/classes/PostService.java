package faang.school.godbless.sprint5.commentary.classes;

import java.util.List;

public class PostService {
    private volatile List<Post> posts;
    private final Object lock = new Object();

    public void addComment(int postId, Comment comment) {
        synchronized (lock) {
            posts.get(postId)
                    .getComments()
                    .add(comment);
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }
}