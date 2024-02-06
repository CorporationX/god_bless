package lostComment_1331;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostService {

    private volatile List<Post> posts = new ArrayList<>();
    private Object lock = new Object();

    public void addComment(Post post, Comment comment) {
        synchronized (lock) {
            post.getComments().add(comment);
            System.out.printf("Добавлен комментарий %s к посту %s \n", comment.getText(), post.getSubject());
        }
    }

    public void addPost(Post post) {
        posts.add(post);
        System.out.println("Добавлен пост " + post.getSubject());
    }
}