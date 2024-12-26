package school.faang.task_51141;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PostService {
    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private AtomicInteger postIdCounter = new AtomicInteger();

    public Post addPost(String title, String content, String author) {
        int id = postIdCounter.getAndIncrement();
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        posts.put(id, post);

        return post;
    }

    public void addComment(int postId, Comment comment) {
        Post post = getPost(postId);
        synchronized (post) {
            post.getComments().add(comment);
        }
    }

    public List<Comment> getComments(int postId) {
        Post post = getPost(postId);
        synchronized (post) {
            return List.copyOf(post.getComments());
        }
    }

    public Post getPost(int postId) {
        Post post = posts.get(postId);
        if (Objects.isNull(post)) {
            throw new IllegalArgumentException("Нет такого поста");
        }

        return post;
    }

    public void deletePost(int postId) {
        posts.remove(postId);
    }

    public void deleteComment(int postId, int commentId) {
        Post post = getPost(postId);
        synchronized (post) {
            post.getComments().remove(commentId);
        }
    }
}
