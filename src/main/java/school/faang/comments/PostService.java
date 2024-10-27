package school.faang.comments;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    public void addComment(int postId, Comment comment) {
        posts.get(postId).getComments().add(comment);
    }

    public void showPost(int postId) {
        System.out.println(posts.get(postId));
    }

    public void showCommentsByPost(int postId) {
        System.out.println(posts.get(postId).getComments());
    }

    public Optional<Post> removePost(int postId, int authorId) {
        return authorId == posts.get(postId).getAuthorId() ? Optional.of(posts.remove(postId)) : Optional.empty();
    }

    public Optional<Comment> removeCommentByAuthorId(int postId, int authorId, String commentText) {
        for (Comment comment : posts.get(postId).getComments()) {
            if (comment.getAuthor().getId() == authorId && comment.getText().equals(commentText)) {
                posts.get(postId).getComments().remove(comment);
                return Optional.of(comment);
            }
        }

        return Optional.empty();
    }
}
