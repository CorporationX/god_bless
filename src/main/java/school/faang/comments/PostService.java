package school.faang.comments;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();

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

    public Post removePost(int postId) {
        return posts.remove(postId);
    }

    public void removeCommentByText(String commentText) {
        posts.entrySet().stream()
                .flatMap(entry -> entry.getValue().getComments().stream())
                .filter(comment -> comment.getText().equals(commentText))
                .findFirst();
    }
}
