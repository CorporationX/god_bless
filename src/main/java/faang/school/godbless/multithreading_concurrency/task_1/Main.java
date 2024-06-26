package faang.school.godbless.multithreading_concurrency.task_1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        final PostService postService = new PostService();
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        final List<User> users = getUsers();
        final List<Post> posts = getPost(users);
        final List<Comment> comments = getComments(users);

        addPostsAsync(executor, postService, posts);
        addCommentsAsync(executor, postService, comments);
        deleteCommentAsync(executor, postService, posts, comments);
        deletePostAsync(executor, postService, posts);
        retrievePostAsync(executor, postService, posts);
        retrieveCommentsAsync(executor, postService, posts);

        executor.shutdown();
    }

    private static void addPostsAsync(ExecutorService executor, PostService postService, List<Post> posts) {
        posts.forEach(post -> executor.submit(() -> postService.addPost(post)));
    }

    private static void addCommentsAsync(ExecutorService executor, PostService postService, List<Comment> comments) {
        executor.submit(() -> postService.addComment(1, comments.get(0)));
        executor.submit(() -> postService.addComment(2, comments.get(1)));
        executor.submit(() -> postService.addComment(3, comments.get(2)));
        executor.submit(() -> postService.addComment(3, comments.get(3)));
        executor.submit(() -> postService.addComment(4, comments.get(4)));
    }

    private static void deleteCommentAsync(ExecutorService executor, PostService postService, List<Post> posts, List<Comment> comments) {
        executor.submit(() -> postService.deleteComment(posts.get(0).getId(), comments.get(0)));
    }

    private static void deletePostAsync(ExecutorService executor, PostService postService, List<Post> posts) {
        executor.submit(() -> postService.deletePost(posts.get(0).getId()));
    }

    private static void retrievePostAsync(ExecutorService executor, PostService postService, List<Post> posts) {
        final Future<Optional<Post>> futurePost =
            executor.submit(() -> postService.getPost(posts.get(1).getId()));
        try {
            futurePost.get().ifPresent(post -> log.info("Got post {}", post));
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error while retrieving post from Future", e);
        }
    }

    private static void retrieveCommentsAsync(ExecutorService executor, PostService postService, List<Post> posts) {
        final Future<Optional<List<Comment>>> futureCommentsFromPost =
            executor.submit(() -> postService.getComments(posts.get(2).getId()));
        try {
            futureCommentsFromPost.get().ifPresent(comments -> log.info("Got comments {}", comments));
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error retrieving comments from Future", e);
        }
    }

    private static List<User> getUsers() {
        return List.of(
            new User(1, "Kostah"),
            new User(2, "Alex"),
            new User(3, "Someone")
        );
    }

    private static List<Post> getPost(List<User> users) {
        return List.of(
            new Post(1, users.get(0), "Java Basics", "Introduction to Java programming."),
            new Post(2, users.get(1), "Kotlin for Beginners", "Getting started with Kotlin."),
            new Post(3, users.get(2), "Kotlin Coroutines", "Understanding coroutines in Kotlin."),
            new Post(4, users.get(1), "Java vs Kotlin", "Comparing Java and Kotlin for Android development.")
        );
    }

    private static List<Comment> getComments(List<User> users) {
        return List.of(
            new Comment(1, users.get(1), "Great introduction to Java!"),
            new Comment(2, users.get(0), "Very helpful for beginners."),
            new Comment(3, users.get(1), "Advanced concepts explained well."),
            new Comment(4, users.get(0), "Coroutines are amazing!"),
            new Comment(5, users.get(0), "Both languages have their strengths.")
        );
    }
}

