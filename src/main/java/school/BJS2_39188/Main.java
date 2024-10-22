package school.BJS2_39188;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(100);
        List<User> listOfUsers = new ArrayList<>();
        PostService postService = new PostService();
        for (int i = 0; i < 10; i++) {
            listOfUsers.add(new User("Пользователь " + i));
        }

        for (int i = 0; i < 10; i++) {
            User randomUser = listOfUsers.get(i);
            Post post = new Post(i, "Название поста " + i, "Какой-то контент", randomUser.getName());
            Comment comment = new Comment("Текст комментария", randomUser.getName(), LocalDate.now());
            CompletableFuture.supplyAsync(() -> {
                postService.addPost(post);
                postService.addComment(post.getId(), comment);
                return null;
            }, service).join();
        }
        service.shutdown();

        postService.printPosts();
        postService.printCommentsFromPost(7);

        postService.removePost(2, listOfUsers.get(2));
        postService.printPosts();


    }
}
