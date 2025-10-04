package school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.volatile_immutable_classes_deadlock_concurrency.bjs2_93619.SampleDate.postGeneration;
import static school.utils.Utils.pickRandom;
import static school.utils.Utils.random;
import static school.utils.Utils.runAwaitAndShutdown;
import static school.utils.Utils.runWithThreadErrorHandling;
import static school.utils.Utils.shutdownAndAwaitTermination;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int NUMBER_OF_COMMENT = 10000;
    private static final int RANDOM_UPPER_BOUND = 200;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static void executeAllAsync(@NonNull List<Runnable> tasks) {
        runAwaitAndShutdown(EXECUTOR_SERVICE,
                () -> tasks.forEach(EXECUTOR_SERVICE::execute));
    }

    public static void main(String[] args) {
        List<Comment> comments = SampleDate.commentGeneration(NUMBER_OF_COMMENT);
        PostService postService = new PostService();
        List<Post> posts = postGeneration();

        List<Runnable> tasksForAddingPosts = posts.stream()
                .map((post) -> (Runnable) () -> {
                    log.info("Пост {}", post.getAuthor());
                    runWithThreadErrorHandling(() -> Thread.sleep(random(RANDOM_UPPER_BOUND)));
                    postService.addPost(post);
                })
                .toList();

        executeAllAsync(tasksForAddingPosts);

        List<Runnable> tasksForAddingComments = comments.stream()
                .map((comment) -> (Runnable) () -> {
                    int idPostRandom = pickRandom(postService.getKeys());
                    runWithThreadErrorHandling(() -> Thread.sleep(10));
                    postService.addComment(idPostRandom, comment);
                    log.info("{}, добавлен в пост {}", comment.text(),
                            postService.getPost(idPostRandom).getTitle());
                })
                .toList();

        executeAllAsync(tasksForAddingComments);

        shutdownAndAwaitTermination(EXECUTOR_SERVICE, 120, TimeUnit.SECONDS);

        int countCommentsAll = posts.stream().map(Post::countComment).reduce(0, Integer::sum);
        log.info("Всего комментариев во всех постах: {}", countCommentsAll);
    }
}