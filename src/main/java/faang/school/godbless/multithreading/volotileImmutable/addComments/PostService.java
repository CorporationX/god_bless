package faang.school.godbless.multithreading.volotileImmutable.addComments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostService {
    private final Object lock = new Object();
    private volatile List<Post> posts = new ArrayList<>();

    public void addComment(Comment comment, int idPost) {
        synchronized (lock) {
            Post post = posts.get(idPost);
            post.getComments().add(comment);
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }
}
