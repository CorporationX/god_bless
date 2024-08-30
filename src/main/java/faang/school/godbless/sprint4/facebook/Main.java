package faang.school.godbless.sprint4.facebook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Main {
    private static final int QUANTITY_OF_USERS = 50;
    private static final int QUANTITY_OF_POSTS = 200;
    private static final int QUANTITY_OF_COMMENTS = 1000;
    private static final List<User> users = new ArrayList<>(QUANTITY_OF_USERS);
    private static final List<Post> posts = new ArrayList<>(QUANTITY_OF_POSTS);
    private static final List<Comment> comments = new ArrayList<>(QUANTITY_OF_COMMENTS);
    private static final Random random = new Random();
    private static final PostService postService = new PostService();

    public static void main(String[] args) {
        createUsersList();
        createPostsList();
        createCommentsList();
        CompletableFuture.allOf(allTasks().toArray(CompletableFuture[]::new))
                .thenRun(postService::printAllPosts)
                .thenRun(postService::printAllComments)
                .join();
    }

    private static <T> void create(int quantity, List<T> list, IntFunction<T> function) {
        IntStream.rangeClosed(1, quantity)
                .mapToObj(function)
                .forEach(list::add);
    }

    private static void createUsersList() {
        create(QUANTITY_OF_USERS, users, number -> new User(number, String.format("User %d", number)));
    }

    private static void createPostsList() {
        create(QUANTITY_OF_POSTS, posts,
                number -> new Post(number, String.format("Post %d", number), getRandomUser()));
    }

    private static void createCommentsList() {
        create(QUANTITY_OF_COMMENTS, comments,
                number -> new Comment(number, String.format("Comment %d", number), getRandomUser()));
    }

    private static User getRandomUser() {
        return users.get(random.nextInt(1, QUANTITY_OF_USERS));
    }

    private static Post getRandomPost() {
        return posts.get(random.nextInt(1, QUANTITY_OF_POSTS));
    }

    private static List<CompletableFuture<Void>> addPosts() {
        return posts.stream()
                .map(post -> CompletableFuture
                        .runAsync(() -> postService.addPost(post)))
                .toList();
    }

    private static List<CompletableFuture<Void>> addComments() {
        return comments.stream()
                .map(comment -> CompletableFuture
                        .runAsync(() -> postService.addComment(getRandomPost(), comment)))
                .toList();
    }

    private static List<CompletableFuture<Void>> deletePosts() {
        return IntStream.rangeClosed(1, QUANTITY_OF_POSTS / 5)
                .mapToObj(number -> CompletableFuture
                        .runAsync(() -> {
                            Post post = getRandomPost();
                            postService.deletePost(post.getAuthor(), post);
                        }))
                .toList();
    }

    private static List<CompletableFuture<Void>> deleteComments() {
        return IntStream.rangeClosed(1, QUANTITY_OF_COMMENTS / 5)
                .mapToObj(number -> CompletableFuture
                        .runAsync(Main::deleteRandomComment))
                .toList();
    }

    private static void deleteRandomComment() {
        Post post = getRandomPost();
        Map<Long, Comment> commentsAtPost = post.getComments();
        if (!commentsAtPost.isEmpty()) {
            List<Long> listId = commentsAtPost.keySet().stream().toList();
            long randomId = listId.get(random.nextInt(0, listId.size()));
            Comment comment = commentsAtPost.get(randomId);
            postService.deleteComment(post.getAuthor(), post, comment);
        }
    }

    private static List<CompletableFuture<Void>> allTasks() {
        List<List<CompletableFuture<Void>>> futures = List.of(addPosts(), addComments(), deleteComments(), deletePosts());
        return futures.stream()
                .flatMap(Collection::stream)
                .toList();
    }
}
