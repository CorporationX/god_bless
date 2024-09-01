package leave.comments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final Object lock = new Object();

    public synchronized void addComment(long postId, Comment comment) {
        synchronized (this.lock) {
            findPostById(postId).ifPresent(post -> {
                post.addComment(comment);
                System.out.printf("Добавлен коментарий: %s \n", comment.getText());
            });
        }
    }

    public void addPost(Post post) {
        synchronized (this.lock) {
            this.posts.add(post);
            System.out.printf("Добавлен пост %s автор %s\n", post.getId(), post.getAuthor().getName());
        }
    }

    public void removePost(Author author, long postId) {
        this.findPostById(postId).ifPresent(post -> {
            if (!post.getAuthor().equals(author)) {
                System.out.println("У вас нет прав на удаление чужого поста");
                return;
            }

            synchronized (this.lock) {
                this.posts.remove(post);
                System.out.printf("Был удалён пост: %d\n", postId);
            }
        });
    }

    public void removeComment(long postId, Comment comment) {
        Optional<Post> post = this.findPostById(postId);

        if (post.isPresent()) {
            post.get().getComments()
                .removeIf(c -> {
                    if (c.equals(comment)) {
                        if (c.getAuthor().equals(comment.getAuthor())) {
                            System.out.printf("Был удалён комментарий: %s\n", comment.getText());

                            return true;
                        } else {
                            System.out.println("Удалять можно только свои комментарии");
                        }
                    }
                    return false;
                });
        }
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
        return this.posts.stream()
                .filter(p -> id == p.getId())
                .findFirst();
    }
}
