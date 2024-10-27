package school.faang.leave.comments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    public static final int NUM_OF_POSTS = 3;
    private static final int NUM_OF_USERS = 5;
    private static final int MAX_NUM_OF_COMMENTS = 100;

    public static void main(String[] args) {
        List<Post> posts = IntStream.rangeClosed(1, NUM_OF_POSTS)
                .mapToObj(i -> new Post(i, "Post" + i, "content" + i, "user" + i))
                .toList();

        PostService postService = new PostService();
        List<CompletableFuture<Void>> futures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post))
                        .thenCompose((voidRes) -> {
                            List<CompletableFuture<Void>> commentFutures = IntStream.rangeClosed(1, NUM_OF_USERS)
                                    .mapToObj(i -> CompletableFuture.runAsync(() -> {
                                        int commentId = ThreadLocalRandom.current().nextInt(1, MAX_NUM_OF_COMMENTS);
                                        Comment comment = Comment.builder()
                                                .id(commentId)
                                                .text("comment " + commentId)
                                                .author("user" + i)
                                                .timestamp(LocalDateTime.now())
                                                .build();
                                        postService.addComment(post.getId(), comment);
                                    }))
                                    .toList();
                            return CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0]));
                        }))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Все комменты добавлены!"))
                .join();

        Post post = posts.get(0);
        System.out.println("Получаем комменты под первым постом...");
        List<Comment> comments = postService.getComments(post.getId());
        comments.forEach(System.out::println);

        System.out.println("Удаляем первый комментарий под постом с котиками.");
        Comment firstComment = comments.get(0);
        postService.removeComment(post.getId(), firstComment.id(), firstComment.author());
        postService.getComments(post.getId()).forEach(System.out::println);

        System.out.println("Удаляем пост про котиков");
        postService.removePost(post.getId(), post.getAuthor());
        postService.getPosts().forEach(System.out::println);
    }
}
