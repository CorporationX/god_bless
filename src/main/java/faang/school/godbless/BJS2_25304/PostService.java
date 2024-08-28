package faang.school.godbless.BJS2_25304;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostService {
    private volatile List<Post> posts;
    private final Object lockComment = new Object();
    private final Object lockPosts = new Object();

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public void addComment(Comment comment, int id) {
        synchronized (lockComment) {
            posts
                    .stream()
                    .filter(postFromList -> postFromList.id() == id)
                    .findFirst()
                    .map(postFromList -> {
                        postFromList.addComment(comment);
                        return postFromList;
                    })
                    .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " doesn't exist"));

        }
    }

    public void addPost(Post post) {
        synchronized (lockPosts){
            posts.add(post);
        }
    }
}
