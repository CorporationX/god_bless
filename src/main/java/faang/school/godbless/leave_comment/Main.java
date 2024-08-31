package faang.school.godbless.leave_comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        PostService postService = new PostService();
        postService.addPost(new Post(1, "post1", "some text", new ArrayList<>(), "user1"));
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(service.submit(writeComment(postService)));
        }
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        Optional<Post> post = postService.getPost(1);
        post.ifPresent(value -> System.out.printf("Total comments:%d", value.getComments().size()));
        postService.removePost(1, "user1");
        service.shutdown();


    }

    private static Runnable writeComment(PostService postService) {
        return () -> {
            int counter = 0;
            while (counter < 1000) {
                counter++;
                String commentText = String.format("comment %d from %s", counter, Thread.currentThread().getName());
                postService.addComment(new Comment(commentText, "", Thread.currentThread().getName()), 1);
            }

        };
    }
}
