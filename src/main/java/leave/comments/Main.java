package leave.comments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 8;
    private static final int POSTS_COUNT = 100;

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);
        PostService postService = new PostService();

        List<Author> authors = List.of(
            new Author("Author 1"),
            new Author("Author 2"),
            new Author("Author 3"),
            new Author("Author 4"),
            new Author("Author 5")
        );
        List<Post> posts = createPosts(authors);

        posts.forEach(post -> {
            executors.execute(() -> postService.addPost(post));
            for (int i = 0; i < 5; i++) {
                executors.execute(() -> postService.addComment(
                    post.getId(),
                    makeRandomComment(post, authors)
                ));
            }
        });
        executors.shutdown();

        try {
            if (!executors.awaitTermination(5, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }

        List<Thread> removeThreads = new ArrayList<>();
        postService.getPosts().values().stream()
            .skip(10)
            .limit(10)
            .forEach(post -> removeThreads.add(
                new Thread(() -> postService.removePost(
                    post.getAuthor(),
                    post.getId()
                )))
            );

        postService.getPosts().values().stream()
            .skip(50)
            .limit(10)
            .forEach(post ->  removeThreads.add(
                new Thread(() -> postService.removeComment(
                    post.getId(),
                    post.getComments().get(1)
                )))
            );

        removeThreads.forEach(thread -> {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        postService.getPosts().values().forEach(post -> {
            postService.showPost(post.getId());
            post.getComments().forEach(Comment::showComment);
        });
    }

    private static Comment makeRandomComment(Post post, List<Author> users) {
        Random random = new Random();
        return new Comment(
            "Коментарий для поста " + post.getId(),
            LocalDateTime.now(),
            users.get(random.nextInt(users.size()))
        );
    }

    private static List<Post> createPosts(List<Author> authors) {
        Random random = new Random();
        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < POSTS_COUNT; i++) {
            posts.add(new Post(
                "Title",
                "Text",
                authors.get(random.nextInt(0, authors.size() - 1))
            ));
        }

        return posts;
    }
}
