package leave_a_comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        PostService postService = new PostService();

        User user1 = new User("Atom2007");
        User user2 = new User("stromstormer");

        Post post1 = new Post("Java", "Potok is very best!!!", user1);
        Post post2 = new Post("C++", "Potok is very best!!!", user1);
        Post post3 = new Post("Python", "Potok is very best!!!", user2);
        Post post4 = new Post("C#", "Potok is very best!!!", user1);
        Post post5 = new Post("Go", "Potok is very best!!!", user2);

        Comment comment1 = new Comment("++++", user1);

        postService.addPost(post1);
        postService.addPost(post2);
        postService.addPost(post3);
        postService.addPost(post4);
        postService.addPost(post5);
        postService.addComment(post1, comment1);

        List<CompletableFuture<Void>> addPostOrComment = new ArrayList<>();
        List<CompletableFuture<Void>> deleteCommentOrPost = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            addPostOrComment.add(CompletableFuture.runAsync(() -> {
                postService.addPost(new Post("C++", "...", user1));
                postService.addPost(new Post("Java", "...", user2));
            }, executorService));
        }

        for (int i = 0; i < 66; i++) {
            Post randomPost = postService.getPosts().get(new Random().nextInt(postService.getPosts().size()));
            addPostOrComment.add(CompletableFuture.runAsync(() ->
                    postService.addComment(randomPost, comment1)));
        }

        Thread.sleep(5000L);

        CompletableFuture.allOf(addPostOrComment.toArray(new CompletableFuture[0])).join();

        deleteCommentOrPost.add(CompletableFuture.runAsync(() ->
                postService.deletePost(post4, user1), executorService));
        deleteCommentOrPost.add(CompletableFuture.runAsync(() ->
                postService.deleteComment(post2, comment1, user1), executorService));
        deleteCommentOrPost.add(CompletableFuture.runAsync(() ->
                postService.deleteComment(post3, comment1, user1), executorService));

        CompletableFuture.allOf(deleteCommentOrPost.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        for (Post post : postService.getPosts()) {
            System.out.println(post.getTitle() + " -> " + postService.getComments(post));
        }
    }
}