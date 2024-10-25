package school.faang.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private final static int COUNT_POST = 10;
    private final static int COUNT_COMMENT= 100;
    private final static int COUNT_COMMENT_TO_DEL = 50;
    private final static int COUNT_POST_TO_DEL = 2;

    public static void main(String[] args) {
        PostService service = new PostService();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        List<String> authors = List.of("FirstAuthor", "SecondAuthor");
        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < COUNT_POST; i++) {
            int finalI = i;
            String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));

            futures.add(CompletableFuture.runAsync(() ->
                    service.addPost(new Post(finalI, "Title " + finalI, "Content", author))));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < COUNT_COMMENT; i++) {
            int postId = ThreadLocalRandom.current().nextInt(COUNT_POST);
            String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));
            Comment newComment = new Comment("Text", author, LocalDateTime.now());
            comments.add(newComment);

            futures.add(CompletableFuture.runAsync(() ->
                    service.addComment(postId, newComment)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < COUNT_COMMENT_TO_DEL; i++) {
            int postId = ThreadLocalRandom.current().nextInt(COUNT_POST);
            String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));
            Comment commentToDelete = comments.get(ThreadLocalRandom.current().nextInt(comments.size()));

            futures.add(CompletableFuture.runAsync(() ->
                    service.deleteComment(postId, commentToDelete, author)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (int i = 0; i < COUNT_POST_TO_DEL; i++) {
            int postId = ThreadLocalRandom.current().nextInt(COUNT_POST/2);
            String author = authors.get(ThreadLocalRandom.current().nextInt(authors.size()));

            futures.add(CompletableFuture.runAsync(() ->
                    service.deletePost(postId, author)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        service.displayAllPosts();
    }
}