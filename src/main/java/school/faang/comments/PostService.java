package school.faang.comments;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {

    private final ReentrantLock lock = new ReentrantLock();
    private final Map<Integer, Post> posts = new LinkedHashMap<>();


    public void addPost(Post post) {
        lock.lock();
        try {
            posts.put(post.id(), post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            if (posts.containsKey(postId)) {
                posts.put(postId, posts.get(postId).updateComment(comment));
            } else {
                System.out.println("Post with Id " + postId + " was not found");
            }
        } finally {
            lock.unlock();
        }
    }

    public Post readPost(int idPost) {
        return posts.get(idPost);
    }

    public List<Comment> readComments(int idPost) {
        if (posts.containsKey(idPost)) {
            return posts.get(idPost).listComments();
        }
        return null;
    }

    public Post deletePost(int idPost) {
        lock.lock();
        Post deletedPost = null;
        try {
            if (posts.containsKey(idPost))
                deletedPost = posts.remove(idPost);
        } finally {
            lock.unlock();
        }
        return deletedPost;
    }

    public void deleteComment(int idPost, String author) {
        lock.lock();
        try {
            posts.get(idPost)
                    .listComments().removeIf(comment1 -> comment1.author().equals(author));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Post with ID " + idPost + " not found.");
        } finally {
            lock.unlock();
        }
    }
}