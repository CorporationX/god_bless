package faang.school.godbless.LeaveComment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Object lockAddComment = new Object();
    private final Object lockAddPost = new Object();

    public void addComment(int id, Comment comment) throws InterruptedException {
        synchronized (lockAddComment) {
            if (posts.size() == 0) {
                posts.wait();
            }
            posts.forEach(post -> {
                if (id == post.id()) {
                    post.comments().add(comment);
                }
            });
        }
    }

    public void addPost(Post post) {
        synchronized (lockAddPost) {
            posts.add(post);
            posts.notify();
        }
    }

    public void getInfo() {
        posts.forEach(System.out::println);
    }
}
