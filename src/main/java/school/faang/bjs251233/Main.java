package school.faang.bjs251233;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws Exception {
        PostService postService = new PostService();

        Thread user1 = new Thread(() -> {
            Post post = new Post(1, "First Post", "This is the first post", "User1");
            postService.addPost(post);
        });
        user1.start();

        Thread user2 = new Thread(() -> {
            Post post = new Post(2, "Second Post", "This is the second post", "User2");
            postService.addPost(post);
        });
        user2.start();

        Thread user3 = new Thread(() -> {
            Comment comment = new Comment("Nice post!", "User3", LocalDateTime.now());
            postService.addComment(1, comment);
        });
        user3.start();

        Thread user4 = new Thread(() -> {
            Comment comment = new Comment("Interesting!", "User4", LocalDateTime.now());
            postService.addComment(2, comment);
        });
        user4.start();

        user1.join();
        user2.join();
        user3.join();
        user4.join();

        postService.deletePost(1, "User2"); // Should fail
        postService.deletePost(1, "User1"); // Should succeed
    }

}
