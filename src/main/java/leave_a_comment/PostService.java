package leave_a_comment;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostService {
    private static final Object LOCK = new Object();
    private volatile List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public void addComment(Post somePost, Comment comment) {
        synchronized (LOCK) {
            posts.stream()
                    .filter(post -> post.getId() == somePost.getId())
                    .findFirst()
                    .ifPresent(post -> post.getComments().add(comment));
        }
    }

    public void addPost(Post post) {
        synchronized (LOCK) {
            posts.add(post);
        }
    }

    public List<Comment> getComments(Post somePost) {
        return posts.stream()
                .filter(post -> post.getId() == somePost.getId())
                .findFirst()
                .map(post -> post.getComments())
                .orElse(new ArrayList<>());
    }

    public synchronized void deletePost(Post post, User user) {
        if (!post.getAuthor().getUserName().equals(user.getUserName())) {
            throw new IllegalArgumentException("Пост может удалить только тот, кто его опубликовал.");
        }
        synchronized (post) {
            posts.remove(post);
        }
    }

    public void deleteComment(Post post, Comment comment, User user) {
        if (!comment.getAuthor().getUserName().equals(user.getUserName())) {
            throw new IllegalArgumentException("Комментарий может удалить только тот, кто его написал.");
        }
        synchronized (post) {
            post.getComments().remove(comment);
        }
    }
}
