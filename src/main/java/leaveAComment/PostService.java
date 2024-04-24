package leaveAComment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostService {
    private volatile  List<Post> posts = new ArrayList<>();

    public void addComment(int id, Comment comment) {
        synchronized (posts.get(id)) {
            posts.get(id).getComments().add(comment);
        }
    }

    public synchronized void addPost(Post post) {
        posts.add(post);
    }


}
