package BJS2_25457;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable addPostTask1 = () -> {
            Post post = new Post(1, "First Post", "This is the content of the first post", "Author1");
            postService.addPost(post);
        };

        Runnable addPostTask2 = () -> {
            Post post = new Post(2, "Second Post", "This is the content of the second post", "Author2");
            postService.addPost(post);
        };

        Runnable addCommentTask = () -> {
            Comment comment = new Comment("Great post!", "Commenter1");
            postService.addComment(1, comment);
        };

        executorService.submit(addPostTask1);
        executorService.submit(addPostTask2);
        executorService.submit(addCommentTask);

        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }

        postService.viewPosts().forEach(System.out::println);
    }
}
