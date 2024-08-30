package commenting;

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
        var postFutures = posts.stream()
                .map(p -> CompletableFuture.runAsync(() -> service.addPost(p)))
                .toList();
        CompletableFuture.allOf(postFutures.toArray(new CompletableFuture[0])).join();
        List<CompletableFuture<Void>> commentFutures = new ArrayList<>();
        var postsIdx = new ArrayList<>(service.getAllPostsId());
        postsIdx.forEach(i -> log.info("post: " + i));
        log.info(posts.get(0).getId() + " " + posts.get(0).getHeader());
        for (Integer postId : postsIdx) {
            log.info("commenting post " + postId);
            CompletableFuture.runAsync(() -> {
                for (int i = 0; i < COMMENT_COUNT; i++) {
                    int finalI = i;
                    commentFutures.add(CompletableFuture.runAsync(() -> service.addComment(
                            new Comment("text", LocalDateTime.now(), "author_" + finalI), postId)));
                }
            });
        }
        int randomIdx = postsIdx.get(ThreadLocalRandom.current().nextInt(postsIdx.size()));
        CompletableFuture.runAsync(() -> service.removePost(randomIdx, service.getPost(randomIdx).getAuthor()));
        CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0])).join();
        posts.forEach(p -> log.info(String.format("post %s : comments %d", p.getHeader(), p.getAllCommentsId().size())));
    }

    private static List<Post> initPost() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < POST_COUNT; i++) {
            posts.add(new Post("header_" + i, "text", "author_" + i));
        }
        return posts;
    }
}
