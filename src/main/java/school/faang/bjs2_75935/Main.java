package school.faang.bjs2_75935;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static List<Author> authors = IntStream.range(0, 10)
        .mapToObj(index -> new Author("Author#%d".formatted(index)))
        .toList();

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        IntStream.range(0, 20)
            .forEach(value -> {
                log.debug("add post#: {}", value);
                CompletableFuture.runAsync(
                    () -> postService.addPost(
                        "title-%d".formatted(getIndex(20)),
                        "content-%d".formatted(getIndex(20)),
                        authors.get(getIndex(9))
                    ), executor
                ).join();
            });
        log.info("total authors is: {}", authors.size());
        log.info("total post is: {}", postService.getPostCount());
        postService.findAllPosts().forEach(post -> log.info("post: {}", post));
    }

    private static int getIndex(Integer maxValue) {
        double dbl = Math.random() / Math.nextDown(1.0);
        return (int) Math.round(maxValue * dbl);
    }
}
