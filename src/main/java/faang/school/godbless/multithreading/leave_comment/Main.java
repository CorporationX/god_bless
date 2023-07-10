package faang.school.godbless.multithreading.leave_comment;

import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private final Random random = new Random();
    private final PostService service = new PostService();


    public static void main(String[] args) {
        Main main = new Main();

        Author authorOne = new Author(1, "Author #1");
        Author authorTwo = new Author(2, "Author #2");

        List<Thread> adderThreads = List.of(
                main.getPostAdderThread(authorOne, 1, 5),
                main.getPostAdderThread(authorTwo, 6, 10),
                main.getCommentAdderThread(authorOne, 1, 5),
                main.getCommentAdderThread(authorTwo, 6, 10)
        );
        adderThreads.forEach(Thread::start);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        List<Thread> removerThreads = List.of(
                main.getPostRemoverThread(authorOne, 1, 5),
                main.getPostRemoverThread(authorTwo, 6, 10),
                main.getCommentRemoverThread(authorOne, 1, 5),
                main.getCommentRemoverThread(authorTwo, 6, 10)
        );
        removerThreads.forEach(Thread::start);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        main.service.getPosts().forEach(System.out::println);
    }

    private Thread getPostAdderThread(Author author, int indexFrom, int indexTo) {
        return new Thread(
                () -> {
                    for (int i = indexFrom; i <= indexTo; i++) {
                        service.addPost(new Post(i, "Post #" + i, "Text #" + i, author));
                    }
                    try {
                        Thread.sleep(random.nextInt(100, 500));
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
                        Thread.sleep(random.nextInt(100, 1000));
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
                        Thread.sleep(random.nextInt(100, 500));
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
                        Thread.sleep(random.nextInt(100, 500));
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                },
                author.getName()
        );
    }
}
