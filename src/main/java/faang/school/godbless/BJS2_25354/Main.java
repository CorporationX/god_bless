package faang.school.godbless.BJS2_25354;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post1 = new Post("Morning", "The best way to wake up is a cold shower!", "Martin");
        Post post2 = new Post("Night", "I fall asleep to the sounds of rain...", "Bella");

        Thread addPost1 = new Thread(() -> postService.addPost(post1));
        Thread addPost2 = new Thread(() -> postService.addPost(post2));
        addPost1.start();
        addPost2.start();

        try {
            addPost1.join();
            addPost2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread addComment1 = new Thread(() -> postService.addComment(0, new Comment("This is crazy!", "Hipster", LocalDateTime.now())));
        Thread addComment2 = new Thread(() -> postService.addComment(1, new Comment("complete nonsense xD", "TOXIC2010", LocalDateTime.now())));
        addComment1.start();
        addComment2.start();

        try {
            addComment1.join();
            addComment2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        postService.getPosts().forEach(post -> {
            System.out.println("Post: " + post.getTitle() + " " + post.getText() + " from " + post.getAuthor());
            post.getComments().forEach(comment ->
                    System.out.println("Comment for " + post.getAuthor() + ": " + comment.getText() + " from " + comment.getAuthor() + " time: " + comment.getDateTime())
            );
        });
    }
}