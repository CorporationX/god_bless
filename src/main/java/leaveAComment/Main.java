package leaveAComment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        PostService service = new PostService();
        Author author = new Author("Nick");

        for (int i = 0; i < 5; i++) {
            EXECUTOR_SERVICE.execute(() -> service.addPost(new Post("Header" + ThreadLocalRandom.current().nextInt(1, 10),
                    "Somthing" + ThreadLocalRandom.current().nextInt(1, 10),
                    author)));
        }

        for (int i = 0; i < 5; i++) {
            EXECUTOR_SERVICE.execute(() -> service.addPost(new Post("SecondHeader" + ThreadLocalRandom.current().nextInt(1, 10),
                    "SecondSomthing" + ThreadLocalRandom.current().nextInt(1, 10),
                    new Author("SecondNickName" + ThreadLocalRandom.current().nextInt(1, 10)))));
        }

        waitTenSeconds();

        System.out.println("\n\n=========CHECK POSTS============");
        service.lookPosts();

        for (int i = 0; i < 10; i++) {
            EXECUTOR_SERVICE.execute(() -> service.addComment(ThreadLocalRandom.current().nextInt(0, service.getPosts().size()),
                    new Comment("SomthingComment" + ThreadLocalRandom.current().nextInt(1, 55),
                            new Author("CommentAuthor" + ThreadLocalRandom.current().nextInt(1, 55)))));
        }

        waitTenSeconds();

        System.out.println("\n\n=========CHECK COMMS============");
        service.getPosts().forEach(service::lookPostAndComments);

        EXECUTOR_SERVICE.execute(() -> service.removePost(author));

        waitTenSeconds();

        System.out.println("\n\n=========CHECK DEL POSTS============");
        service.getPosts().forEach(service::lookPostAndComments);

        EXECUTOR_SERVICE.shutdown();
    }

    static void waitTenSeconds() {
        try {
            EXECUTOR_SERVICE.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
