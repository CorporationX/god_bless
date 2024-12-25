package school.faang.task51122;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int START = 0;
    private static final int END = 10;
    private static final int NEW_POST_END_RANGE = 50;
    private static final String NAME_REGEX = "name%d";
    private static final String TEXT_REGEX = "text%d";
    private static final String TITLE_REGEX = "title%d";
    private static final String COMMENT_REGEX = "comment%d";

    public static void main(String[] args) {
        List<Author> authors = IntStream.range(START, END)
                .boxed()
                .map(i -> new Author(i, String.format(NAME_REGEX, i)))
                .toList();

        CompletableFuture<List<Comment>> future = CompletableFuture.supplyAsync(() ->
                IntStream.range(0, ThreadLocalRandom.current().nextInt(END))
                        .boxed()
                        .map(i -> new Comment(String.format(TEXT_REGEX, i),
                                authors.get(i),
                                LocalDateTime.now()))
                        .collect(Collectors.toList()));

        PostService postService = new PostService(IntStream.range(START, END)
                .boxed()
                .map(i -> new Post(i,
                        String.format(TITLE_REGEX, i),
                        String.format(COMMENT_REGEX, i),
                        authors.get(i),
                        future.join()
                ))
                .collect(Collectors.toList()));

        CompletableFuture.allOf(IntStream.range(START, END)
                        .boxed()
                        .map(i -> CompletableFuture
                                .runAsync(() -> {
                                    int randomNumber = ThreadLocalRandom.current().nextInt(START, NEW_POST_END_RANGE);
                                    Author author = authors.get(i);
                                    Post post = new Post(randomNumber,
                                            String.format(TITLE_REGEX, randomNumber),
                                            String.format(COMMENT_REGEX, randomNumber),
                                            author,
                                            new ArrayList<>());

                                    postService.addPost(post);

                                    Comment comment = new Comment(
                                            String.format(TEXT_REGEX, randomNumber),
                                            author,
                                            LocalDateTime.now());

                                    postService.addComment(randomNumber, comment);

                                    postService.removeComment(author, comment);

                                    postService.removePost(author, post);

                                })
                                .thenRun(postService::printAllPost)
                                .thenRun(postService::printAllComments))
                        .toArray(CompletableFuture[]::new))
                .join();
    }
}
