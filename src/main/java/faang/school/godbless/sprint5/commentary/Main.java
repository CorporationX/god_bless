package faang.school.godbless.sprint5.commentary;

import faang.school.godbless.sprint5.commentary.classes.Comment;
import faang.school.godbless.sprint5.commentary.classes.Post;
import faang.school.godbless.sprint5.commentary.classes.PostService;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREAD = 5;

    @SneakyThrows
    public static void main(String[] args) {
        PostService service = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

        for (int i = 1; i <= 100; i++){
            executor.submit(() -> service.addPost(new Post()));
            if (i % 2 == 0){
                int finalI = i;
                executor.submit(() -> service.addComment(finalI, new Comment()));
            }
        }

        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Executor terminated");
        }
    }
}
