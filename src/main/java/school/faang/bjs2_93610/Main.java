package school.faang.bjs2_93610;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService service = new PostService();

        Post post = new Post(1, "Title 1", "Content 1", "Author 1");
        service.addPost(post);

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int userId = i + 1;
            threads[i] = new Thread(() -> {
                Comment comment = new Comment(
                        "comment from user " + userId,
                        "user " + userId,
                        LocalDateTime.now()
                );
                service.addComment(1, comment);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        service.viewPost(1);
        service.viewComments(1);
    }
}
