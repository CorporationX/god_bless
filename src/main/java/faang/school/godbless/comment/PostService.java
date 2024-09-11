package faang.school.godbless.comment;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private final List<Post> posts = new ArrayList<>();

    private final Object lockPosts = new Object();

    public void addComment(@NonNull Comment comment, @NonNull Post post) {
        synchronized (post) {
            post.addComment(comment);
        }
    }

    public void addPost(@NonNull Post post) {
        synchronized (lockPosts) {
            posts.add(post);
        }
    }

    public void deletePost(@NonNull Post post, @NonNull Author author) {
        if (post.getAuthor().equals(author)) {
            synchronized (lockPosts) {
                posts.remove(post);
            }
        }
    }

    public void printAllPosts() {
        synchronized (lockPosts) {
            posts.forEach(System.out::println);
            System.out.println("Count comments from all posts " +
                    posts.stream()
                            .mapToInt(post -> post.getComments().size())
                            .sum());
        }
    }
}
