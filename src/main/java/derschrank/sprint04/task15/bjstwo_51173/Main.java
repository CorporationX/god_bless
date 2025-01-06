package derschrank.sprint04.task15.bjstwo_51173;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int COUNT_OF_POSTS = 100;
    private static final int COUNT_OF_COMMENTS = 1000;

    public static void main(String[] args) {

        PostService service = new PostService();

        Author ivan = new Author("Ivan");
        Author petr = new Author("Petr");

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_POSTS; i++) {
            final int msgId = i;
            futures.add(CompletableFuture.runAsync(
                            () -> service.addPost(new Post(msgId, "Title #", "Message #", ivan))
                    )
                    .thenRun(
                            () -> IntStream.range(0, COUNT_OF_COMMENTS).forEach(
                                    commentNumber -> CompletableFuture.runAsync(
                                            () -> service.addComment(
                                                    msgId,
                                                    new Comment(
                                                            "Post#" + msgId + "-Comment#" + commentNumber,
                                                            ivan,
                                                            LocalDateTime.now()
                                                    )
                                            )
                                    )
                            )
                    )
            );
        }

        futures.forEach(CompletableFuture::join);

    }
}
