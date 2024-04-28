package faang.school.godbless.concurrency.task_1;

import faang.school.godbless.concurrency.task_1.model.Comment;
import faang.school.godbless.concurrency.task_1.model.Post;
import faang.school.godbless.concurrency.task_1.model.User;
import faang.school.godbless.concurrency.task_1.service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 4;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(POOL_SIZE);
    private static final int NUMBERS_OF_COMMENTS_OR_POSTS = 7;

    public static void main(String[] args) {
        PostService postService = new PostService();
        User ignat = new User("ignat");
        User magomed = new User("maga");
        List<Post> postsForRemoving = new ArrayList<>();
        List<Comment> commentsForRemoving = new ArrayList<>();
        List<CompletableFuture<Void>> addingCommentsOrPosts = new ArrayList<>();
        List<CompletableFuture<Void>> removingCommentsOrPosts = new ArrayList<>();
        for (int index = 0; index < NUMBERS_OF_COMMENTS_OR_POSTS; index++) {
            int numberOfElement =  index + 1;
            addingCommentsOrPosts.add(CompletableFuture.runAsync(() -> {
                Post post = new Post("Header " + numberOfElement, "Text", magomed);
                postService.addPost(post);
                postsForRemoving.add(postService.getPost(numberOfElement));
                }, EXECUTOR));
            addingCommentsOrPosts.add(CompletableFuture.runAsync(() -> {
                Comment comment = new Comment("comment  " + numberOfElement, ignat, numberOfElement);
                postService.addComment(comment);
                commentsForRemoving.add(comment);
                }, EXECUTOR));
        }
        CompletableFuture.allOf(addingCommentsOrPosts.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    commentsForRemoving.forEach(comment -> {
                        removingCommentsOrPosts.add(CompletableFuture.runAsync(() -> {
                            postService.deleteComment(comment, comment.getAuthor());
                            }, EXECUTOR)
                        );
                    });
                }).thenRun(() -> {
                    postsForRemoving.forEach(post -> {
                        removingCommentsOrPosts.add(CompletableFuture.runAsync(() -> {
                            postService.deletePost(post, post.getAuthor());
                        }, EXECUTOR));
                    });
                }).join();
        CompletableFuture.allOf(removingCommentsOrPosts.toArray(new CompletableFuture[0]));
        EXECUTOR.shutdown();
    }
}
