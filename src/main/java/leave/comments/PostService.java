package leave.comments;

import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class PostService {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    public void addComment(long postId, Comment comment) {
        findPostById(postId).ifPresent(post -> {
            synchronized (post) {
                post.addComment(comment);
                System.out.printf("Добавлен коментарий: %s \n", comment.getText());
            }
        });
    }

    public void addPost(Post post) {
        this.posts.put(post.getId(), post);
        System.out.printf("Добавлен пост %s автор %s\n", post.getId(), post.getAuthor().getName());
    }

    public void removePost(Author author, long postId) {
        this.findPostById(postId).ifPresent(post -> {
            synchronized (post) {
                if (!post.getAuthor().equals(author)) {
                    System.out.println("У вас нет прав на удаление чужого поста");
                    return;
                }

                this.posts.remove(postId);
                System.out.printf("Был удалён пост: %d\n", postId);
            }
        });
    }

    public void removeComment(long postId, Comment comment) {
        this.findPostById(postId).ifPresent(post -> {
            synchronized (post) {
                post.removeComment(comment);
            }
        });
    }

    public void showPost(long id) {
        Post post = this.findPostById(id)
                .orElseThrow(() -> new RuntimeException(id + " пост не найден"));

        System.out.printf(
            "Автор поста: '%s', заголовок: '%s' количество комментариев: %s\n",
            post.getAuthor().getName(),
            post.getTitle(),
            post.getComments().size()
        );
    }

    private Optional<Post> findPostById(long id) {
        return Optional.ofNullable(this.posts.get(id));
    }
}
