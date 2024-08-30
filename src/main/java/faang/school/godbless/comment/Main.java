package faang.school.godbless.comment;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_COUNT = 5;
    private static final int POST_COUNT = 3;
    private static final int COMMENT_COUNT = 15;

    public static void main(String[] args) {
        List<Post> posts = createPostList();
        List<Comment> comments = createCommentList();

        PostService postService = new PostService();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        CompletableFuture<Void> future1 = CompletableFuture.allOf(
                posts.stream()
                        .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post), executorService))
                        .toArray(CompletableFuture[]::new));

        CompletableFuture<Void> future2 = CompletableFuture.allOf(
                comments.stream()
                        .map(comment -> CompletableFuture.runAsync(() ->
                                postService.addComment(getPost(posts, getRandomPostId(POST_COUNT)), comment), executorService))
                        .toArray(CompletableFuture[]::new));

        future1.join();
        future2.join();

        executorService.execute(postService::printAllPosts);

        Post existedPost = getPost(posts, getRandomPostId(POST_COUNT));

        executorService.execute(() -> postService.removePost(existedPost, existedPost.getAuthor()));

        executorService.execute(postService::printAllPosts);

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println("Работа завершена!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    private static List<Post> createPostList() {
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= POST_COUNT; i++) {
            posts.add(new Post("title" + i, "text" + i, "author" + i));
        }

        return posts;
    }

    private static List<Comment> createCommentList() {
        List<Comment> comments = new ArrayList<>();
        for (int i = 1; i <= COMMENT_COUNT; i++) {
            comments.add(new Comment("text" + i, "author" + i));
        }

        return comments;
    }

    private static int getRandomPostId(int max) {
        return (int) (Math.random() * max);
    }

    private static Post getPost(List<Post> posts, int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .toList()
                .get(0);
    }
}
