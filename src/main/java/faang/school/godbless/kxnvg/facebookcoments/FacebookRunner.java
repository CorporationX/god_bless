package faang.school.godbless.kxnvg.facebookcoments;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FacebookRunner {

    private static final List<User> USERS = new ArrayList<>();
    private static final List<String> COMMENTS = new ArrayList<>();

    static {
        USERS.add(new User("Nikita"));
        USERS.add(new User("Vlad"));
        USERS.add(new User("Inna"));
        USERS.add(new User("Ilon"));
        USERS.add(new User("Max"));

        COMMENTS.add("like");
        COMMENTS.add("dislike");
        COMMENTS.add(":)");
        COMMENTS.add("good!");
        COMMENTS.add("... === ...");
    }

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        PostService postService = new PostService();

        for (User user : USERS) {
            executorService.execute(() -> postService.addPost("Topic", "Some text", user));
        }
        executorService.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            service.execute(() -> {
                int randomId = new Random().nextInt(5);
                int randomComment = new Random().nextInt(5);
                int randomUser = new Random().nextInt(5);
                postService.addComment(randomId, COMMENTS.get(randomComment), USERS.get(randomUser));
            });
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(postService.getPost(3));
        System.out.println(postService.getAllTextOfCommentsFromPost(4));

        List<Comment> allCommentsFromPost = postService.getAllCommentsFromPost(0);
        allCommentsFromPost.forEach(System.out::println);
        System.out.println(allCommentsFromPost.size());
    }
}
