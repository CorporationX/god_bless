package faang.school.godbless.leaveComment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final Lock lock = new ReentrantLock();
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = getPostById(postId);
            if (post != null) {
                post.addComments(comment);
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = getPostById(postId);
            if (post != null) {
                post.deleteComment(comment.getAuthor());
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        return posts;
    }


    private Post getPostById(int postId) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }

}
