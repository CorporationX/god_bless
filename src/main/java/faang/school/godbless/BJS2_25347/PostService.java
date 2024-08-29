package faang.school.godbless.BJS2_25347;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();

    ReentrantLock lockCommnent = new ReentrantLock();
    ReentrantLock lockPost = new ReentrantLock();

    public void addComment(Comment comment) {
        lockCommnent.lock();
        Post post = comment.getPost();
        post.addComment(comment);
        posts.set(post.getId(), post);
        lockCommnent.unlock();
    }

    public void addPost(Post post) {
        lockPost.lock();
        posts.add(post);
        lockPost.unlock();
    }
}
