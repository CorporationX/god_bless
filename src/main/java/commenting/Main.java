package commenting;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int POST_COUNT = 20;
    private static final int COMMENT_COUNT = 30;

    public static void main(String[] args) {
        PostService service = new PostService();
        var posts = initPost();
        addPosts(posts, service);
        var postsIdx = service.getAllPostsId();
        int randomIdx = postsIdx.get(ThreadLocalRandom.current().nextInt(postsIdx.size()));
        var comments = addComments(service);
        CompletableFuture.runAsync(() -> service.removePost(randomIdx, service.getPost(randomIdx).getAuthor()));
        deleteComments(comments, service);
        posts.forEach(p -> log.info(
                String.format("post %s : comments %d", p.getHeader(), p.getAllCommentsId().size())));
    }

    private static List<Post> initPost() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < POST_COUNT; i++) {
            posts.add(new Post("header_" + i, "text", "author_" + i));
        }
        return posts;
    }

    private static void addPosts(@NonNull List<Post> posts, @NonNull PostService service) {
        var postFutures = posts.stream()
                .map(p -> CompletableFuture.runAsync(() -> service.addPost(p)))
                .toList();
        CompletableFuture.allOf(postFutures.toArray(new CompletableFuture[0])).join();
    }

    private static List<Comment> addComments(@NonNull PostService service) {
        List<CompletableFuture<Void>> commentFutures = new ArrayList<>();
        var postsIdx = new ArrayList<>(service.getAllPostsId());
        List<Comment> comments = new ArrayList<>();
        for (Integer postId : postsIdx) {
            commentFutures.add(CompletableFuture.runAsync(() -> {
                List<CompletableFuture<Void>> futures = new ArrayList<>();
                addCommentsToPost(postId, comments, futures, service);
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            }));
        }
        CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0])).join();
        return comments;
    }

    private static void addCommentsToPost(int postId,
                                          @NonNull List<Comment> comments,
                                          @NonNull List<CompletableFuture<Void>> futures,
                                          @NonNull PostService service) {
        for (int i = 0; i < COMMENT_COUNT; i++) {
            Comment comment = new Comment("text", LocalDateTime.now(), "author_" + i);
            comments.add(comment);
            futures.add(CompletableFuture.runAsync(() -> service.addComment(
                    comment, postId)));
        }
    }

    private static void deleteComments(@NonNull List<Comment> comments, @NonNull PostService service) {
        List<CompletableFuture<Void>> commentDelFutures = new ArrayList<>();
        var commentIdx = new ArrayList<>(service.getAllCommentsId());
        for (int i = 0; i < 10; i++) {
            int commentId = commentIdx.remove(ThreadLocalRandom.current().nextInt(commentIdx.size()));
            Comment comment = comments.stream()
                    .filter(com -> com.getId() == commentId)
                    .findFirst()
                    .orElseThrow();
            commentDelFutures.add(
                    CompletableFuture.runAsync(() -> service.removeComment(comment.getId(), comment.getAuthor())));
        }
        CompletableFuture.allOf(commentDelFutures.toArray(new CompletableFuture[0])).join();
    }
}
