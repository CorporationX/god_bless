package FacebookComments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Object postLock = new Object();
    private final Object commentLock = new Object();

    public void addComment(int id, Comment comment){
        synchronized (commentLock) {
            posts.get(id).getComments().add(comment);
            System.out.println("Comment added");
        }
    }

    public void addPost(Post post){
        synchronized (postLock){
            posts.add(post);
            System.out.println("Post added");
        }
    }
}
