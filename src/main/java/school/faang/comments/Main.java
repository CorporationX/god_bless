package school.faang.comments;

public class Main {
    private static final int DELAY_TIME = 100;

    public static void main(String[] args) {
        PostService postService = new PostService();

        Thread t1 = new Thread(() -> {
            Post post = new Post(1, "Hello", "First post!", "Alice");
            postService.addPost(post);
        });
        t1.start();

        sleep(DELAY_TIME);

        Thread t2 = new Thread(() -> {
            Comment comment = new Comment("Nice post!", "Bob");
            postService.addComment(1, comment);
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            Comment comment = new Comment("Thanks for sharing.", "Charlie");
            postService.addComment(1, comment);
        });
        t3.start();

        Thread t4 = new Thread(() -> postService.deletePost(1, "Bob"));
        t4.start();

        Thread t5 = new Thread(() -> postService.deletePost(1, "Alice"));
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
