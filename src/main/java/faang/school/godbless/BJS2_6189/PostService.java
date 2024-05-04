package faang.school.godbless.BJS2_6189;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PostService {
    private volatile Map<Integer, Post> posts;

    public PostService() {
        this.posts = new HashMap<>();
    }

    public void addComment(Post post, Comment comment) {
        posts.get(post.getId()).addComment(comment);
    }

    public void deleteComment(Post post, Comment comment, String author) {
        if (comment.getAuthor().equals(author)) {
            posts.get(post.getId()).deleteComment(comment);
        }
    }

    public List<Comment> getComments(Post post) {
        return post.getComments();
    }

    public void addPost(Post post) {
        if (post != null) {
            posts.put(posts.size() + 1, post);
        } else {
            System.out.println("нельзя добавить пост");
        }
    }

    public void deletePost(Post post, String author) {
        if (post != null && post.getAuthor().equals(author)) {
            posts.remove(post.getId());
        } else {
            System.out.println("нельзя удалить комментарий");
        }
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }
}
