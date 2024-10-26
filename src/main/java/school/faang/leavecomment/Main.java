package school.faang.leavecomment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int NUMBER_OF_POSTS = 3;
    private static final int NUMBER_OF_USERS = 5;
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        PostService postService = new PostService();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 1; i <= NUMBER_OF_POSTS; i++) {
            int postId = i;
            executorService.submit(() -> addPost(postService, postId));
        }

        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            int userId = i;
            executorService.submit(() -> addComment(postService, userId));
        }

        executorService.shutdown();
    }

    private static void addPost(PostService postService, int postId) {
        Post post = new Post(postId, "Post " + postId, "Content for post " + postId, "User" + postId);
        postService.addPost(post);
        System.out.println("Post added: " + post.getTitle());
    }

    private static void addComment(PostService postService, int userId) {
        Comment comment = new Comment("This is comment " + userId, "User" + userId, LocalDateTime.now());
        postService.addComment(1, comment);
        System.out.println("Comment added by User" + userId);
    }
}


