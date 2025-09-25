package school.faang.bjs2_93607;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int SIZE_POOL_THREAD = 10;
    private static final int SLEEP_WAITING = 5;
    private static Map<Post, Author> mapPost = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Author author1 = new Author("iLya", "asd", 17);
        Author author2 = new Author("Alina", "qwtgefs", 16);
        Author author3 = new Author("Olga", "afdhng", 65);
        Author author4 = new Author("Vitalka", "aweqrqw", 54);
        Author author5 = new Author("Sacha", "qwerfasd", 47);
        Author author6 = new Author("Victor", "sdfasd", 56);
        Author author7 = new Author("Dima", "awsdfasd", 34);
        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);
        authorList.add(author3);
        authorList.add(author4);
        authorList.add(author5);
        authorList.add(author6);
        authorList.add(author7);

        ExecutorService executor = Executors.newFixedThreadPool(SIZE_POOL_THREAD);
        PostService postService = new PostService();
        authorList.stream().forEach(author -> {
            Post post = new Post(AtomicId.getId(),
                    author.getName(),
                    author.getSurname(),
                    author,
                    new ArrayList<>());
            mapPost.put(post, author);
            executor.submit(() -> postService.addPost(post));
        });

        authorList.stream().forEach(author -> {
            mapPost.keySet().stream().forEach(post -> {
                if (!Objects.equals(mapPost.get(post), author)) {
                    executor.execute(() -> postService.addComment(post.getId(),
                            new Comment(author.getSurname(), author, LocalDateTime.now())));
                }
            });
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(SLEEP_WAITING, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            new InterruptedException(e.getMessage());
        }
        mapPost.keySet().stream().forEach(post -> {
            postService.getPostAndComments(post.getId());
            postService.removePost(post.getId());
        });
        log.info("После удаления");

        mapPost.keySet().stream().forEach(post -> {
            postService.getPostAndComments(post.getId());
            postService.removePost(post.getId());
        });
    }
}
