package Concurrency_1;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 1; i < 51; i++) {
            int finalI = i;
            service.submit(() -> PostService.addPost("User" + finalI));
            service.submit(() -> PostService.addComment(PostService.getIdPost(), "User" + finalI));
            service.submit(() -> PostService.deleteComment(PostService.getIdPost(), "User" + finalI));
        }

        service.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread has failed");
        }

        for (Map.Entry<Integer, Post> post : PostService.getPosts().entrySet()) {
            System.out.println("Post id" + post.getKey() + ": " + post.getValue().getAuthor() + " add post: " + post.getValue().getText());
            for (Comment comment : post.getValue().getComments()) {
                System.out.println(comment.getText());
            }
        }
    }
}
