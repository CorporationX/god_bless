package faang.school.godbless.comments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addComment(Comment comment, Post post) {
        lock.lock();
        try {
            if (posts.contains(post)) {
                post.addComment(comment);
                System.out.printf("The comment '%s' is added to %s\n", comment.getText(), post.getTitle());
            } else {
                System.out.println("There is no such post!");
            }
        } finally {
            lock.unlock();
        }
    }

    public void addPost (Post post){
        lock.lock();
        try {
            posts.add(post);
            System.out.printf("Post with title '%s' is published\n", post.getTitle());
        }finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        return posts;
    }
}
