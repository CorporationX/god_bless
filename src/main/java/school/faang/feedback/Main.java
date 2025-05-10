package school.faang.feedback;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService service = new PostService();

        Thread t1 = new Thread(() -> service.addPost(new Post(1, "Первый пост", "Привет, мир!",
                "Alice")));
        t1.start();

        Thread t2 = new Thread(() -> service.addPost(new Post(2, "Второй пост", "Это тестовый пост.",
                "Bob")));
        t2.start();

        Thread t3 = new Thread(() -> {
            Comment comment = new Comment("Отличный пост!", "Charlie");
            service.addComment(1, comment);
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            Comment comment = new Comment("Спасибо за инфу!", "Dave");
            service.addComment(1, comment);
        });

        t4.start();

        t1.join();
        t2.join();



        t3.join();
        t4.join();

        service.viewPosts();

        service.deletePost(1, "Eve");

        service.deletePost(1, "Alice");

        service.viewPosts();
    }
}
