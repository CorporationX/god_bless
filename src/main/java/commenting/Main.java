package commenting;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int POST_COUNT = 20;
    private static final int COMMENT_COUNT = 30;

    public static void main(String[] args) {
        PostService service = new PostService();
        var posts = initPost();
        var postFutures = posts.stream()
                .map(p -> CompletableFuture.supplyAsync(() -> service.addPost(p)))
                .toList();
        var postsIdx = postFutures.stream()
                .map(CompletableFuture::join)
                .toList();
        List<CompletableFuture<Void>> commentFutures = new ArrayList<>();
        for (Integer id : postsIdx) {
            for (int j = 0; j < COMMENT_COUNT; j++) {
                int finalJ = j;
                commentFutures.add(CompletableFuture.runAsync(() -> service.addComment(new Comment(
                        "comment text", LocalDateTime.now(), "comment_author_" + finalJ), id)));
            }
        }
        CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0])).join();
        posts.forEach(p -> log.info(String.format("post %s : comments %d", p.getHeader(), p.getComments().size())));
    }

    private static List<Post> initPost() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < POST_COUNT; i++) {
            posts.add(new Post("header_" + i, "text", "author_" + i));
        }
        return posts;
    }
}
