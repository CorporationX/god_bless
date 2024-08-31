package faang.school.godbless.bjs225556;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        PostService postService = new PostService();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");
        User user4 = new User(4, "David");
        User user5 = new User(5, "Eve");
        User user6 = new User(6, "Frank");
        User user7 = new User(7, "Grace");
        User user8 = new User(8, "Hank");

        Comment comment1 = new Comment(1, "First comment on post 1 by Alice", LocalDateTime.now(), user1);
        Comment comment2 = new Comment(2, "Second comment on post 1 by Bob", LocalDateTime.now(), user2);
        Comment comment3 = new Comment(3, "Third comment on post 1 by Charlie", LocalDateTime.now(), user3);
        Comment comment4 = new Comment(4, "Fourth comment on post 1 by David", LocalDateTime.now(), user4);
        Comment comment5 = new Comment(5, "Fifth comment on post 1 by Eve", LocalDateTime.now(), user5);
        Comment comment6 = new Comment(6, "Sixth comment on post 1 by Frank", LocalDateTime.now(), user6);
        Comment comment7 = new Comment(7, "Seventh comment on post 1 by Grace", LocalDateTime.now(), user7);
        Comment comment8 = new Comment(8, "Eighth comment on post 1 by Hank", LocalDateTime.now(), user8);

        Post post1 = new Post(1, "Post 1 Header", "Post 1 Text", user1);
        Post post2 = new Post(2, "Post 2 Header", "Post 2 Text", user2);

        List<Post> postsToBeAdded = new ArrayList<>(List.of(post1, post2));
        List<Comment> commentsToBeAdded = new ArrayList<>(List.of(comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8));

        List<CompletableFuture<Void>> allFuturePosts = new ArrayList<>();
        List<CompletableFuture<Void>> allFutureComments = new ArrayList<>();

        for (var post : postsToBeAdded) {
            CompletableFuture<Void> futurePost = CompletableFuture.runAsync(() -> postService.addPost(post));
            allFuturePosts.add(futurePost);
        }
        CompletableFuture.allOf(allFuturePosts.toArray(new CompletableFuture[0])).join();

        for (var comment : commentsToBeAdded) {
            CompletableFuture<Void> futureComment = CompletableFuture.runAsync(() -> postService.addComment(1, comment));
            allFutureComments.add(futureComment);
        }
        CompletableFuture.allOf(allFutureComments.toArray(new CompletableFuture[0])).join();
        postService.showPost(1);

        List<CompletableFuture<Void>> allFutureDeletes = new ArrayList<>();
        CompletableFuture<Void> futureDelete1 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 1, user1));
        allFutureDeletes.add(futureDelete1);
        CompletableFuture<Void> futureDelete2 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 2, user2));
        allFutureDeletes.add(futureDelete2);
        CompletableFuture<Void> futureDelete3 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 3, user3));
        allFutureDeletes.add(futureDelete3);
        CompletableFuture<Void> futureDelete4 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 4, user4));
        allFutureDeletes.add(futureDelete4);
        CompletableFuture<Void> futureDelete5 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 5, user5));
        allFutureDeletes.add(futureDelete5);
        CompletableFuture<Void> futureDelete6 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 6, user6));
        allFutureDeletes.add(futureDelete6);
        CompletableFuture<Void> futureDelete7 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 7, user7));
        allFutureDeletes.add(futureDelete7);
        CompletableFuture<Void> futureDelete8 = CompletableFuture.runAsync(() -> postService.deleteComment(1, 8, user8));
        allFutureDeletes.add(futureDelete8);

        CompletableFuture.allOf(allFutureDeletes.toArray(new CompletableFuture[0])).join();
        postService.showPost(1);
    }
}
