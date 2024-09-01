package faang.school.godbless.leaveacomment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {
    private final Map<Integer, Post> posts;

    public PostService() {
        this.posts = new ConcurrentHashMap<>();
    }

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public void removePost(int postId, String author) {
        Post post = posts.get(postId);
        if (post != null && post.getAuthor().equals(author)) {
            posts.remove(postId);
        }
    }

    public void addComment(int postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null) {
            post.addComment(comment);
        }
    }

    public void removeComment(int postId, Comment comment, String author) {
        Post post = posts.get(postId);
        if (post != null && comment.getAuthor().equals(author)) {
            post.removeComment(comment);
        }
    }

    public Map<Integer, Post> getPosts() {
        return new ConcurrentHashMap<>(posts);
    }
}