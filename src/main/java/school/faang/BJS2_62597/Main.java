package school.faang.BJS2_62597;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable postTask = () -> {
            Post post = new Post(1, "My first post", "This is the content", "User1");
            postService.addPost(post);
            System.out.println("Post added: " + post.getTitle());
        };

        Runnable commentTask = () -> {
            Post post = new Post(2, "Another post", "Some content", "User2");
            postService.addPost(post);
            Comment comment = new Comment("Nice post!", "User3");
            postService.addComment(post.getId(), comment);
            System.out.println("Comment added by " + comment.getAuthor());
        };

        for (int i = 0; i < 2; i++) {
            executor.execute(postTask);
        }
        executor.execute(commentTask);

        executor.shutdown();
    }
}
