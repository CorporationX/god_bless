package school.faang.comments;

public class Main {
    private static final int DELAY_TIME = 100;

    public static void main(String[] args) {
        PostService postService = new PostService();

        Thread t1 = new Thread(() -> {
            Post post = new Post(1, "Hello", "First post!", "Alice");
            postService.addPost(post);
        });

        Thread t2 = new Thread(() -> {
            Comment comment = new Comment("Nice post!", "Bob");
            postService.addComment(1, comment);
        });

        Thread t3 = new Thread(() -> {
            Comment comment = new Comment("Thanks for sharing.", "Charlie");
            postService.addComment(1, comment);
        });

        Thread t4 = new Thread(() -> postService.deletePost(1, "Bob"));

        Thread t5 = new Thread(() -> postService.deletePost(1, "Alice"));

        t1.start();
        sleep(DELAY_TIME);
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
