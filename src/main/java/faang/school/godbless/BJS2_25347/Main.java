package faang.school.godbless.BJS2_25347;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Author> authors = createAuthors(20);
        List<Post> posts = postService.getPosts();
        Random random = new Random();
        IntStream.range(0, 100)
                .forEach(i -> executor.execute(() -> postService
                        .addPost(new Post(i, "Title_" + i, "Somecontent_" + i, authors.get(ThreadLocalRandom.current().nextInt(authors.size()))))));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        IntStream.range(0, 400)
                .forEach(i -> executor.execute(() -> postService.addComment(
                        new Comment(i, "SomeComment_" + i, LocalDateTime.now(), authors.get(ThreadLocalRandom.current().nextInt(authors.size())), posts.get(ThreadLocalRandom.current().nextInt(posts.size())))))
                );

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
//        postService.getPosts().forEach(System.out::println);
        postService.getPosts().stream()
                .flatMap(post -> post.getComments().stream())
                .forEach(System.out::println);
    }

    public static List<Author> createAuthors(int count) {
        return IntStream.range(1, count)
                .mapToObj(i -> new Author(i, "Author_" + i))
                .toList();
    }
}
