package faang.school.godbless.comment;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Object lock = new Object();

    public void addPost(@NonNull Post post) {
        synchronized (lock) {
            posts.add(post);
        }
    }

    public void addComment(int id, @NonNull Comment comment) {
        synchronized (lock) {
            if (id < 0 || id > posts.size()) {
                throw new IllegalArgumentException("id out of range");
            }
            findPost(id).getComments().add(comment);
        }
    }

    private Post findPost(int id) {
        return posts.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new NoSuchElementException("Post not found"));
    }
}
