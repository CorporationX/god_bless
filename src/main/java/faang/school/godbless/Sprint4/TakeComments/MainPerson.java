package faang.school.godbless.Sprint4.TakeComments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MainPerson {
    private volatile boolean status;
    private boolean programLaunch = true;
    static final PostService postService = new PostService();

    public static void main(String[] args) throws InterruptedException {
        MainPerson admin = new MainPerson();
        //пользователь в сети

        admin.status = true;

        new Thread(() -> {
            try {
                admin.updateIdComments();
            } catch (InterruptedException e) {
                System.out.println("updateIdComments was crashed");
            }
        }).start();

        Post post1 = new Post("admin1", LocalDate.now());
        Post post2 = new Post("admin2", LocalDate.now());
        Post post3 = new Post("admin3", LocalDate.now());
        Post post4 = new Post("admin4", LocalDate.now());

        Comment willRemove = new Comment("comment for remove", LocalDate.now(), "admin3");

        List<CompletableFuture> executors = new ArrayList<>();

        executors.add(CompletableFuture.supplyAsync(() -> {
            postService.addPost(post1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.addComment(post2, new Comment("comment2", LocalDate.now(), "admin1"));
            return null;
        }));
        executors.add(CompletableFuture.supplyAsync(() -> {
            postService.addPost(post2);
            postService.addComment(post2, willRemove);
            return null;
        }));
        executors.add(CompletableFuture.supplyAsync(() -> {
            postService.addPost(post3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.removeComment(post2, willRemove);
            return null;
        }));
        executors.add(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.addPost(post4);
            postService.addComment(post4, new Comment("comment4", LocalDate.now(), "admin4"));
            return null;
        }));
        executors.add(CompletableFuture.supplyAsync(() -> {
            postService.addPost(post4);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postService.removePost(post3);
            return null;
        }));

        CompletableFuture.allOf(executors.toArray(new CompletableFuture[0])).join();
        System.out.println("||| End of the program |||");

        //вышел из сети, можно обновлять id
        admin.status = false;
        Thread.sleep(3000);
        admin.status = true;
        postService.getPosts().forEach(System.out::println);
        admin.programLaunch=false;
    }

    public void updateIdComments() throws InterruptedException {
        while (programLaunch) {
            if (!status) {
                postService.updateRemovedComments();
                Thread.sleep(10000);
            }
        }
    }

}
