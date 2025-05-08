package school.faang.leavecomment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {
    private static final int THREAD_COUNT = 8;
    private static final int NUMBER_OF_POSTS = 5;
    private static final int COMMENTS_PER_POST = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        PostService postService = new PostService();
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 1; i <= NUMBER_OF_POSTS; i++) {
            final int postId = i;
            final String authorName = "PostAuthor-" + postId;
            futures.add(executor.submit(() -> {
                Thread.currentThread().setName(authorName);
                Post post = new Post(
                        postId,
                        Thread.currentThread().getName(),
                        "Title of post #" + postId,
                        "Content of post #" + postId
                );
                postService.addPost(post);
            }));
        }
        waitAll(futures);
        futures.clear();

        for (Post post : postService.getAllPosts()) {
            final int pid = post.getId();
            for (int j = 1; j <= COMMENTS_PER_POST; j++) {
                final int commentId = j;
                final String commenter = "CommentAuthor-" + pid + "-" + commentId;
                futures.add(executor.submit(() -> {
                    Thread.currentThread().setName(commenter);
                    Comment comment = new Comment(
                            commentId,
                            Thread.currentThread().getName(),
                            LocalDateTime.now(),
                            "Text of comment #" + commentId + " on post " + pid
                    );
                    postService.addComment(pid, comment);
                }));
            }
        }
        waitAll(futures);
        futures.clear();

        System.out.println("\n=== All posts and their comments ===");
        for (Post post : postService.getAllPosts()) {
            System.out.printf("%s%s", post, postService.getAllCommentsByPostId(post.getId()).stream()
                    .map(c -> c.toString() + "\n")
                    .collect(Collectors.joining()));
        }
        System.out.println();

        final int removePostId = 2;
        futures.add(executor.submit(() -> {
            String remover = "PostAuthor-" + removePostId;
            Thread.currentThread().setName(remover);
            postService.removePostById(removePostId, remover);
            System.out.printf("[%s] removed post with id %d\n", remover, removePostId);
        }));

        final int removeCommentPostId = 3;
        final int removeCommentId = 1;
        futures.add(executor.submit(() -> {
            String remover = "CommentAuthor-" + removeCommentPostId + "-" + removeCommentId;
            Thread.currentThread().setName(remover);
            postService.removeComment(removeCommentPostId, removeCommentId, remover);
            System.out.printf("[%s] removed comment #%d from post %d\n", remover, removeCommentId, removeCommentPostId);
        }));

        waitAll(futures);
        futures.clear();

        System.out.println("\n=== Final posts and their comments ===");
        for (Post post : postService.getAllPosts()) {
            System.out.printf("%s%s", post, postService.getAllCommentsByPostId(post.getId()).stream()
                    .map(c -> c.toString() + "\n")
                    .collect(Collectors.joining()));
        }

        executor.shutdown();
    }

    private static void waitAll(List<Future<?>> futures) {
        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            }
        }
    }
}
