package faang.school.godbless.sprint4.facebook;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostService {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();

    public void addPost(Post post) {
        posts.put(post.getId(), post);
        System.out.printf("Пост с id %d успешно добавлен%n", post.getId());
    }

    public void deletePost(User user, Post post) {
        synchronized (post) {
            if (isAvailableToDelete(user, post.getId())) {
                posts.remove(post.getId());
                System.out.printf("Пост с id %d успешно удален%n", post.getId());
            }
        }
    }

    public void addComment(Post post, Comment comment) {
        post.addComment(comment);
    }

    public void deleteComment(User user, Post post, Comment comment) {
        post.deleteComment(user, comment.getId());
    }


    private boolean isAvailableToDelete(User user, long postId) {
        if (!posts.containsKey(postId)) {
            System.out.printf("Пост с id %s не найден%n", postId);
            return false;
        }
        if (!user.equals(posts.get(postId).getAuthor())) {
            System.out.printf("Пользователь %s не является автором поста с id %d%n", user, postId);
            return false;
        }
        return true;
    }

    public void printAllPosts() {
        posts.values().forEach(System.out::println);
    }

    public void printAllComments() {
        posts.values()
                .stream()
                .flatMap(post -> post.getComments().values().stream())
                .forEach(System.out::println);
    }
}
