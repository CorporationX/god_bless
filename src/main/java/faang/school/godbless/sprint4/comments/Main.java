package faang.school.godbless.sprint4.comments;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post1 = new Post(1, "Заголовок 1", "Текст 1", "Автор 1");
        Post post2 = new Post(2, "Заголовок 2", "Текст 2", "Автор 2");

        Comment comment1 = new Comment("Комментарий 1", "Автор комментария 1");
        Comment comment2 = new Comment("Комментарий 2", "Автор комментария 2");

        Thread thread1 = new Thread(() -> {
            postService.addPost(post1);
            postService.addComment(1, comment1);
        });

        Thread thread2 = new Thread(() -> {
            postService.addPost(post2);
            postService.addComment(1, comment2);
        });

        Thread thread3 = new Thread(() -> {
            postService.deleteComment(1, "Автор комментария 2");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(post1.getComments());
        System.out.println("Все потоки завершены");
    }

}

