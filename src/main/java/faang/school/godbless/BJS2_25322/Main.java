package faang.school.godbless.BJS2_25322;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        PostService service = new PostService();

        String userOne = "Frank";
        String userTwo = "John";
        String userThree = "Mark";
        String userFour = "Wilson";

        Post userOnePost = new Post(1, "Morning!", "Who came up with the idea that running in the morning is good?", userOne);
        Comment userTwoComment = new Comment("Satan, heh", userTwo, LocalDateTime.now());
        Comment userOneComment = new Comment("I start WALKING to church", userOne, LocalDateTime.now());
        Comment userThreeComment = new Comment("actually, there is a lot of research on this topic", userThree, LocalDateTime.now());
        Post userFourPost = new Post(2, "Delicious food", "How to make toast for breakfast?", userFour);

        Runnable userOneAddPost = () -> {
            service.addPost(userOnePost);
        };

        Runnable userTwoAddComment = () -> {
            sleepWithTryCatchBlock(3000);
            service.addComment(userOnePost.getId(), userTwoComment);
        };

        Runnable userOneAddComment = () -> {
            sleepWithTryCatchBlock(7000);
            service.addComment(userOnePost.getId(), userOneComment);
        };

        Runnable userThreeAddComment = () -> {
            sleepWithTryCatchBlock(7000);
            service.addComment(userOnePost.getId(), userThreeComment);
        };

        Runnable userFourAddPost = () -> {
            sleepWithTryCatchBlock(3000);
            service.addPost(userFourPost);
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Stream.of(userOneAddPost, userTwoAddComment, userOneAddComment, userThreeAddComment, userFourAddPost)
                .forEach(executor::execute);
        executor.shutdown();
    }

    private static void sleepWithTryCatchBlock(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
