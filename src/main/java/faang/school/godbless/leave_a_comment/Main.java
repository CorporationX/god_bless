package faang.school.godbless.leave_a_comment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        PostService postService = new PostService();
        User bob = new User("Bob");
        User misha = new User("Misha");
        Comment comment = new Comment("first", misha, 0);
        Post post = new Post("Test", "content", bob);
        postService.addPost(post);
        postService.addComment(comment);

        List<CompletableFuture<Void>> addCommentOrPost = new ArrayList<>();
        List<CompletableFuture<Void>> deleteCommentOrPost = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            addCommentOrPost.add(CompletableFuture.runAsync(() ->
                    postService.addComment(new Comment("test" + ThreadLocalRandom.current().nextInt(), bob, 0)),
                    executorService
            ));
        }

        for (int i = 0; i < 5; i++) {
            addCommentOrPost.add(CompletableFuture.runAsync(() ->
                    postService.addPost(new Post("new", "test" + ThreadLocalRandom.current().nextInt(), misha)),
                    executorService
            ));
        }

        CompletableFuture.allOf(addCommentOrPost.toArray(new CompletableFuture[0])).join();

        deleteCommentOrPost.add(CompletableFuture.runAsync(() -> postService.deleteComment(comment, bob), executorService));
        deleteCommentOrPost.add(CompletableFuture.runAsync(() -> postService.deleteComment(comment, misha), executorService));
        deleteCommentOrPost.add(CompletableFuture.runAsync(() -> postService.deletePost(post, bob), executorService));

        CompletableFuture.allOf(deleteCommentOrPost.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();
    }
}