package faang.school;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            String temp = Integer.toString(i);
            var thread = new Thread(() -> {
                postService.addPost(new Post(temp, temp, temp));
                postService.addComment(new Comment(temp, temp, Instant.now(), temp), ThreadLocalRandom.current().nextInt(1, 10));
            }
            );
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(postService.getPosts());
    }
}
