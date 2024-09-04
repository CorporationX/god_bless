package faang.school.godbless.BJS2_25597;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            int postId = i;
            executorService.submit(() -> {
                Post post = new Post("Title " + postId, "Author " + postId, "This is the content of post " + postId);
                postService.addPost(post);
                System.out.println("Added post by " + post.getAuthor() + ": " + post.getTitle());
            });
        }

        for (int i = 0; i < 5; i++) {
            int postId = i;
            executorService.submit(() -> {
                Comment comment = new Comment("This is a comment for post " + (postId + 1), LocalDateTime.now(), "CommentAuthor " + (postId + 1));
                postService.addComment(comment, postId);
                System.out.println("Added comment by " + comment.getAuthor() + " to post " + (postId + 1));
            });
        }

        executorService.shutdown();
    }
}
