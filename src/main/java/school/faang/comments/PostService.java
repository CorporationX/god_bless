package school.faang.comments;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PostService {
    private volatile ArrayList<Post> posts = new ArrayList<>();

    public synchronized void addPost(Post post) {
        posts.add(post);
    }

    public void addComment(int postId, Comment comment) {
        Post targetPost = posts.stream()
                .filter(post -> post.getId() == postId).findFirst()
                .orElseThrow(() -> new RuntimeException("Post not found"));
        synchronized (targetPost) {
            targetPost.getComments().add(comment);
        }
    }

    public synchronized void deletePost(int postId, User author) {
        posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
    }

    public synchronized void deleteComment(int postId, LocalDateTime localDateTime, User author) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                post.getComments().removeIf(comment ->
                    comment.getTimestamp().equals(localDateTime) && comment.getAuthor().equals(author));
            }
        }
    }
}
