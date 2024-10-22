package school.BJS2_39188;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private volatile List<Post> posts = new ArrayList<>();

    public synchronized void addPost(Post post) {
        posts.add(post);
    }

    public synchronized void addComment(int postId, Comment comment) {
        posts.stream().filter(post -> post.getId() == postId).forEach(post -> post.getComments().add(comment));
    }

    public synchronized void removePost(int postId, User user) {
        posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(user.getName()));
    }

    public synchronized void removeComment(int postId, LocalDate time, User user) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                String commentAuthor = post.getAuthor();
                String userName = user.getName();
                post.getComments().removeIf(comment -> commentAuthor.equals(userName) &&
                        comment.getTimestamp().equals(time));
            }
        }
    }

    public void printPosts() {
        posts.stream().forEach(post -> System.out.println(post));
    }
    public void printCommentsFromPost(int postId) {
        posts.stream().filter(post -> post.getId() == postId).forEach(post -> System.out.println(post.getComments()));
    }

}