package school.faang.facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class PostService {
    private final List<Post> posts = new CopyOnWriteArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
        log.info("Пост добавлен: {}", post.getTitle());
    }

    public void addComment(int postId, Comment comment) {
        findPostById(postId).ifPresent(post -> {
            post.addComment(comment);
            log.info("Комментарий добавлен к посту {} от {}", postId, comment.getAuthor());
        });
    }

    public boolean removePost(int postId, String requester) {
        return posts.removeIf(post ->
                post.getId() == postId && post.hasAuthor(requester));
    }

    public boolean removeComment(int postId, Comment comment, String requester) {
        return findPostById(postId)
                .map(post -> post.removeComment(comment, requester))
                .orElse(false);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts);
    }

    private Optional<Post> findPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }
}
