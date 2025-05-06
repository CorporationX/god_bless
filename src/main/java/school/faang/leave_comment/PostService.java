package school.faang.leave_comment;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PostService {
    private final Queue<Post> posts = new ConcurrentLinkedDeque<>();

    public void addPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Errorrrr!!!!");
        }
        posts.add(post);
    }

    public void addComment(int postId, Comment comment) {
        if (posts.stream().noneMatch(post -> post.id() == postId)) {
            throw new IllegalArgumentException("Errorrrr!!");
        }
        for (Post post : posts) {
            if (post.id() == postId) {
                post.addComment(comment);
                break;
            }
        }
    }

    public void removePost(int postId) {
        if (posts.stream().noneMatch(post -> post.id() == postId)) {
            throw new IllegalArgumentException("Errorrrr!!");
        }
        for (Post post : posts) {
            if (post.id() == postId) {
                posts.remove(post);
                break;
            }
        }
    }

    public void printAllPosts() {
        posts.forEach(System.out::println);
    }
}
