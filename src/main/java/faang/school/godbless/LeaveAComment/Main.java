package faang.school.godbless.LeaveAComment;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            executor.submit(() -> postService.addPost(new Post(1, "First Post", "This is the first post", "Author1", new CopyOnWriteArrayList<>())));
            executor.submit(() -> postService.addPost(new Post(2, "Second Post", "This is the second post", "Author2", new CopyOnWriteArrayList<>())));

            executor.submit(() -> postService.addComment(1, new Comment("First comment", "Commenter1", new Date())));
            executor.submit(() -> postService.addComment(1, new Comment("Second comment", "Commenter2", new Date())));

            executor.submit(() -> {
                for (Post post : postService.getPosts()) {
                    System.out.println("Post: " + post.getTitle() + " by " + post.getAuthor());
                    for (Comment comment : post.getComments()) {
                        System.out.println("  Comment: " + comment.getText() + " by " + comment.getAuthor());
                    }
                }
            });

            executor.submit(() -> {
                Post post = postService.getPosts().get(0);
                Comment comment = post.getComments().get(0);
                postService.removeComment(post.getId(), comment);
            });

            executor.submit(() -> postService.removePost(1, "Author1"));
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}

