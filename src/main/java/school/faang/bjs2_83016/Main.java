package school.faang.bjs2_83016;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        ExecutorService executor = Executors.newCachedThreadPool();

        String[] users = {"Alice", "Bob", "Charlie", "Diana"};

        for (int i = 0; i < users.length; i++) {
            final int postId = i + 1;
            final String author = users[i];
            executor.submit(() -> {
                Post post = new Post(postId, "Title " + postId, "Content of post " + postId, author);
                postService.addPost(post);
                System.out.println(author + " добавил пост с id " + postId);
            });
        }

        Thread.sleep(1000);

        for (int i = 0; i < users.length * 2; i++) {
            final int postId = (i % users.length) + 1;
            final String author = users[i % users.length];
            final String text = "Комментарий " + (i + 1) + " от " + author;

            executor.submit(() -> {
                Comment comment = new Comment(text, author, LocalDateTime.now());
                boolean success = postService.addComment(postId, comment);
                if (success) {
                    System.out.println(author + " добавил комментарий к посту " + postId);
                } else {
                    System.out.println(author + " не смог добавить комментарий к посту " + postId);
                }
            });
        }

        Thread.sleep(2000);

        executor.submit(() -> {
            boolean deleted = postService.deletePost(1, "Alice");
            System.out.println("Пост 1 удалён Alice: " + deleted);
        });

        executor.submit(() -> {
            boolean deleted = postService.deletePost(1, "Bob");
            System.out.println("Пост 1 удалён Bob: " + deleted);
        });

        executor.shutdown();

        if (!executor.isTerminated()) {
            executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
        }

        System.out.println("\nТекущие посты и комментарии:");

        for (Post post : postService.getPosts()) {
            System.out.println("Post id=" + post.getId() + ", author=" + post.getAuthor() + ", title=" +
                               post.getTitle());

            for (Comment comment : post.getComments()) {
                System.out.println("   Comment by " + comment.getAuthor() + ": " + comment.getText());
            }
        }
    }
}
