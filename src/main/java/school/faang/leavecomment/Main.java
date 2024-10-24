package school.faang.leavecomment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 3; i++) {
            int postId = i;
            executorService.submit(() -> {
                Post post = new Post(postId, "Post " + postId, "Content for post " + postId, "User" + postId);
                postService.addPost(post);
                System.out.println("Post added: " + post.getTitle());
            });
        }

        for (int i = 0; i < 5; i++) {
            int userId = i;
            executorService.submit(() -> {
                Comment comment = new Comment("This is comment " + userId, "User" + userId, LocalDateTime.now());
                postService.addComment(1, comment);
                System.out.println("Comment added by User" + userId);
            });
        }

        executorService.shutdown();
    }
}

