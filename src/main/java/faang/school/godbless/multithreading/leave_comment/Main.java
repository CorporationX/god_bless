package faang.school.godbless.multithreading.leave_comment;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private final PostService service = new PostService();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Author authorOne = new Author(1, "Author #1");
        Author authorTwo = new Author(2, "Author #2");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(main.getPostAdderThread(authorOne, 1, 5));
        executor.execute(main.getPostAdderThread(authorTwo, 6, 10));
        executor.execute(main.getCommentAdderThread(authorOne, 1, 5));
        executor.execute(main.getCommentAdderThread(authorTwo, 6, 10));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        executor.execute(main.getPostRemoverThread(authorOne, 1, 5));
        executor.execute(main.getPostRemoverThread(authorTwo, 6, 10));
        executor.execute(main.getCommentRemoverThread(authorOne, 1, 5));
        executor.execute(main.getCommentRemoverThread(authorTwo, 6, 10));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        main.service.getPosts().forEach(System.out::println);
    }

    private Thread getPostAdderThread(Author author, int indexFrom, int indexTo) {
        return new Thread(
                () -> {
                    for (int i = indexFrom; i <= indexTo; i++) {
                        service.addPost(new Post(i, "Post #" + i, "Text #" + i, author));
                    }
                    try {
                        Thread.sleep(new Random().nextInt(100, 500));
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                },
                author.getName()
        );
    }

    private Thread getCommentAdderThread(Author author, int indexFrom, int indexTo) {
        return new Thread(
                () -> {
                    for (int i = indexFrom; i <= indexTo; i++) {
                        service.addComment(new Comment(i, "Comment #" + i, author), i);
                    }
                    try {
                        Thread.sleep(new Random().nextInt(100, 1000));
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                },
                author.getName()
        );
    }

    private Thread getPostRemoverThread(Author author, int indexFrom, int indexTo) {
        return new Thread(
                () -> {
                    for (int i = indexFrom; i <= indexTo; i++) {
                        service.removePost(author, i);
                    }
                    try {
                        Thread.sleep(new Random().nextInt(100, 500));
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                },
                author.getName()
        );
    }

    private Thread getCommentRemoverThread(Author author, int indexFrom, int indexTo) {
        return new Thread(
                () -> {
                    for (int i = indexFrom; i <= indexTo; i++) {
                        service.removeComment(author, i);
                    }
                    try {
                        Thread.sleep(new Random().nextInt(100, 500));
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                },
                author.getName()
        );
    }
}
