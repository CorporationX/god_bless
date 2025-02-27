package school.faang.sprint4.task_64466;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final PostService POST_SERVICE = new PostService(EXECUTOR);
    private static final Random RANDOM = new Random();
    private static final int COMMENT_COUNT = 20;
    private static final int POST_SIZE = 5;
    private static final List<CompletableFuture<Void>> FUTURE_COMMENTS = new ArrayList<>();
    private static final List<Post> POSTS = createObject(POST_SIZE, Main::createPost);
    private static final List<Comment> COMMENTS = createObject(COMMENT_COUNT, Main::createComment);

    public static void main(String[] args) {
        POSTS.forEach(POST_SERVICE::addPost);
        COMMENTS.forEach(comment -> FUTURE_COMMENTS.add(POST_SERVICE.addComment(getRandomPostId(), comment)));

        CompletableFuture.allOf(FUTURE_COMMENTS.toArray(CompletableFuture[]::new))
                .thenRun(EXECUTOR::shutdownNow).join();

        POST_SERVICE.printPosts();
    }

    private static <T> List<T> createObject(int count, IntFunction<T> mapper) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(mapper)
                .toList();
    }

    private static Post createPost(int num) {
        return new Post(num, "Post Title " + num, "Content of post " + num, "Author" + num, new ArrayList<>());
    }

    private static Comment createComment(int num) {
        return new Comment("comment_" + num, "Commenter" + num, LocalDateTime.now());
    }

    private static int getRandomPostId() {
        return POSTS.get(RANDOM.nextInt(0, POSTS.size())).id();
    }
}
