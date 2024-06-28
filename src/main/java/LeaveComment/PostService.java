package LeaveComment;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private final Object lock = new Object();
    private final List<Post> posts = new ArrayList<>();

    public void addComment(@NonNull int id, Comment comment) {
        synchronized (lock) {
            posts.stream()
                    .filter(post -> post.getID() == id)
                    .findFirst()
                    .ifPresent(post -> post.addComment(comment));
        }
    }

    public void addPost(@NonNull Post post) {
        synchronized (lock) {
            System.out.println("add Post " + post.getTitle());
            posts.add(post);
        }
    }

    public void deletePost(@NonNull String user, Post post) {
        synchronized (lock) {
            if (user.equals(post.getAuthor())) {
                posts.remove(post);
                System.out.println("Post deleted");
            } else {
                System.out.println("This user is not the owner of the post");
            }
        }
    }

    public void deleteComment(@NonNull String user, Comment comment, Post post) {
        synchronized (lock) {
            if (user.equals(comment.getName()) && posts.contains(post)) {
                post.deleteComment(comment);
            } else {
                System.out.println("This comment belongs to another user");
            }
        }
    }

    public void printPosts() {
        posts.forEach(post -> System.out.println(post.getTitle()));
    }

    public void printComment() {
        posts.forEach(Post::print);
    }
}