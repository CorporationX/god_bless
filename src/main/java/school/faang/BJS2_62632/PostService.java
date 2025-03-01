package school.faang.BJS2_62632;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Getter
@Slf4j
public class PostService {
    private final ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap<>();

    // Добавление поста
    public void addPost(Post post) {
        posts.put(post.getId(), post);
    }

    // Добавление комментария к посту
    public void addComment(int postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null) {
            post.getComments().add(comment);
        } else {
            log.warn("Пост с ID {} не найден.", postId);
        }
    }

    // Просмотр всех постов
    public void viewPosts() {
        posts.values().forEach(System.out::println);
    }

    // Удаление поста (только автором)
    public boolean deletePost(int postId, String author) {
        Post post = posts.get(postId);
        if (post != null && post.getAuthor().equals(author)) {
            posts.remove(postId);
            return true;
        }
        return false;
    }

    // Удаление комментария (только автором)
    public boolean deleteComment(int postId, Comment comment) {
        Post post = posts.get(postId);
        if (post != null && comment.getAuthor().equals(post.getAuthor())) {
            return post.getComments().remove(comment);
        }
        return false;
    }
}