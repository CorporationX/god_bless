package faang.school.godbless.LeaveAComment;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private volatile List<Post> posts = new CopyOnWriteArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addComment(int id, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == id) {
                    post.addComment(comment);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
        return posts;
    }


    public void removePost(int id, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == id && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int id, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == id && comment.getAuthor().equals(post.getAuthor())) {
                    post.removeComment(comment);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public Post getPostById(int id) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == id) {
                    return post;
                }
            }
            return null;
        } finally {
            lock.unlock();
        }
    }
}
