package LeaveComment;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class PostService {
    private static final Object lock = new Object();
    private static final List<Post> posts = createPosts();

    public static List<Post> createPosts() {
        return Arrays.asList(
                new Post(1, "Bob", "Dragon", "text1"),
                new Post(2, "Rob", "Home", "text2"),
                new Post(3, "Tom", "PHP", "text3"),
                new Post(4,"Bart", "World", "text4"));
    }

    public void addComment(int id, Comment comment) {
        synchronized (lock) {
            posts.stream().filter(post -> post.getID() == id).forEach(post -> post.addComment(comment));
        }
    }

    public void addPost(@NonNull Post post) {
        synchronized (lock) {
            System.out.println("added Post " + post.getTitle());
            posts.add(post);
        }
    }

    public static void deletePost(@NonNull String user, Post post) {
        synchronized (lock) {
            if (user.equals(post.getAuthor())) {
                posts.remove(post);
                System.out.println("Пост удален");
            } else {
                System.out.println("Этот пользователь не владелец поста");
            }
        }
    }

    public static void deleteComment(@NonNull String user, Comment comment, Post post) {
        synchronized (lock) {
            if (user.equals(comment.getName()) && posts.contains(post)) {
                post.deleteComment(comment);
            } else {
                System.out.println("Этот коментарий пренадлежит другому пользователю");
            }
        }
    }

    public void printPosts() {
        posts.forEach(post -> System.out.println(post.getTitle()));
    }

    public void printComment() {
        posts.forEach(post -> post.print());
    }
}
