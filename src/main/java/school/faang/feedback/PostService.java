package school.faang.feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("Пост добавлен: " + post.getTitle());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> postOpt = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst();
            if (postOpt.isPresent()) {
                postOpt.get().addComment(comment);
                System.out.println("Комментарий добавлен к посту " + postId + " автором " + comment.getAuthor());
            }
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String requester) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(requester));
            System.out.println("Пост удалён (если права были у " + requester + ")");
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, Comment comment, String requester) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    if (comment.getAuthor().equals(requester)) {
                        post.removeComment(comment);
                        System.out.println("Комментарий удалён автором " + requester);
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void viewPosts() {
        lock.lock();
        try {
            posts.forEach(post -> {
                System.out.println(post.getTitle() + " (Автор: " + post.getAuthor() + ")");
                post.getComments().forEach(comment ->
                        System.out.println("    Коммент: " + comment.getText() + " от " + comment.getAuthor()));
            });
        } finally {
            lock.unlock();
        }
    }
}
