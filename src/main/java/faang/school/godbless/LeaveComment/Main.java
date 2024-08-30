package faang.school.godbless.LeaveComment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        PostService postService = new PostService();
        postService.addPost(new Post("dota", "kunkka", "adsad"));

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(() -> postService.addCommentToPostById(0, new Comment(Integer.toString(finalI), "a")));
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(() -> postService.addPost(new Post(Integer.toString(finalI), "me", "assa")));
        }

        postService.printAllCommentsByPostId(0);
        postService.printAllPosts();

        executor.shutdownNow();
    }
}
