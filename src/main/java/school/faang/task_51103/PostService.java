package school.faang.task_51103;

import school.faang.exception.CheckException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class PostService {
    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private static final String POST_BY_ID_NOT_FOUND = "Пост по id: %s не найден";

    public CompletableFuture<Void> addPost(Post newPost, ExecutorService executorService) {
        if (newPost == null) {
            throw new CheckException("newPost");
        } else if (posts.stream().anyMatch(post -> post.getId() == newPost.getId())) {
            String msg = "В списке постов уже имеется пост с id: %s%n";
            throw new CheckException(msg, List.of(String.valueOf(newPost.getId())));
        }
        return CompletableFuture.runAsync(() -> {
            posts.add(newPost);
            System.out.printf("Пост %s добавлен!%n", newPost.getTitle());
        }, executorService);
    }

    public CompletableFuture<Void> addComment(int postId, Comment comment, ExecutorService executorService) {
        Post post = getPostById(postId);
        return CompletableFuture.runAsync(() -> post.addCommentToPost(comment), executorService);
    }

    public void deletePost(String author, int postId) {
        authorCheck(author);
        Post existsPost = getPostById(postId);
        if (!existsPost.getAuthor().equals(author)) {
            throw new CheckException("В посте id: %s указан другой автор",
                    List.of(String.valueOf(postId)));
        }
        posts.remove(existsPost);
        System.out.printf("Пост с id: %s и автором: %s удален!%n", postId, author);
    }

    public void deleteComment(String author, int postId) {
        authorCheck(author);
        Post existsPost = getPostById(postId);
        existsPost.deleteCommentByAuthor(author);
    }

    public void showPostsWithComments() {
        posts.forEach(post -> {
            System.out.printf("Пост: %s%nАвтор поста: %s%n", post.getContent(), post.getAuthor());
            System.out.println("Комментарии:");
            if (!post.getComments().isEmpty()) {
                final int[] i = {1};
                post.getComments().forEach(comment -> {
                    System.out.printf("%s. %s%nАвтор комментария: %s%n",
                            i[0], comment.getText(), comment.getAuthor());
                    i[0]++;
                });
            } else {
                System.out.println("Нет комментариев");
            }
        });
    }

    private void authorCheck(String author) {
        if (author == null || author.isEmpty()) {
            throw new CheckException("author");
        }
    }

    private Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new CheckException(POST_BY_ID_NOT_FOUND, List.of(String.valueOf(postId))));
    }
}
