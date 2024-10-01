package faang.school.godbless.leave_comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostService {
    private final List<Post> posts = new ArrayList<>();

    void addComment(Comment comment, int id) {
        synchronized (posts) {
            Optional<Post> post = posts.stream().filter(item -> item.getId() == id).findFirst();
            post.ifPresent(value -> value.getComments().add(comment));
        }
    }

    void addPost(Post post) {
        synchronized (posts) {
            posts.add(post);
        }
    }

    void removePost(int id, String user) {
        synchronized (posts) {
            posts.removeIf(item -> item.getId() == id && item.getAuthor().equals(user));
        }
    }

    Optional<Post> getPost(int id) {
        synchronized (posts) {
            return posts.stream().filter(item -> item.getId() == id).findFirst();
        }
    }
}
