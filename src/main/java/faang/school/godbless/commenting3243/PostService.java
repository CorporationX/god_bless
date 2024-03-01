package faang.school.godbless.commenting3243;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    @Getter private volatile List<Post> posts;
    private final static Object POSTS_LOCK = new Object();

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public void addComment(Comment comment, Post post) {
        synchronized (POSTS_LOCK) {
            if (isSpam(comment, post)) {
                System.out.println("""
                        (ANTI SPAM FILTER)
                        You can't leave the same comment""");
                return;
            }
            if (!post.getComments().contains(comment)) {
                post.getComments().add(comment);
            }
        }
    }

    public void addPost(Post post) {
        synchronized (POSTS_LOCK) {
            if (!posts.contains(post)) {
                posts.add(post);
                return;
            }
            System.out.println("Post already exists");
        }
    }

    public void deleteComment(Comment comment, Post post, String whoTriesToDelete) {
        synchronized (POSTS_LOCK) {
            if (comment.getAuthor().equals(whoTriesToDelete) || post.getAuthor().equals(whoTriesToDelete)) {
                post.getComments().remove(comment);
            } else {
                System.out.println("You have no rights to delete that comment");
            }
        }
    }

    public void deletePost(Post post, String whoTriesToDelete) {
        synchronized (POSTS_LOCK) {
            if (whoTriesToDelete.equals(post.getAuthor())) {
                posts.remove(post);
            } else {
                System.out.println("You have no rights to delete that post");
            }
        }
    }

    private boolean isSpam(Comment comment, Post post) {
        boolean isSpam = false;
        String commentText = comment.getText();
        String commentAuthor = comment.getAuthor();
        List<Comment> postComments = post.getComments();

        for (Comment postComment : postComments) {
            if (postComment.getText().equalsIgnoreCase(commentText) &&
                    postComment.getAuthor().equals(commentAuthor)) {
                isSpam = true;
                break;
            }
        }
        return isSpam;
    }
}
