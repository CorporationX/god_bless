package tasks.bjs2_33307;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EventType {
    ADD_POST("{accountId: %d, post: Какой то пост}"),
    DELETE_POST("{accountId: %d, postId: %d}"),
    LIKE_POST("{accountId: %d, postId: %d}"),
    DISLIKE_POST("{accountId: %d, postId: %d}"),
    SHARE_POST("{accountId: %d, postId: %d}"),
    ADD_FRIEND("{accountId: %d, userId: %d}"),
    REMOVE_FRIEND("{accountId: %d, userId: %d}"),
    BLOCK_USER("{accountId: %d, userId: %d}"),
    UNBLOCK_USER("{accountId: %d, userId: %d}"),
    ADD_COMMENT("{accountId: %d, userId: %d, comment: Какой-то коммент}"),
    DELETE_COMMENT("{accountId: %d, userId: %d, commentId: %d}"),
    ADD_IMAGE("{userId: %d, byte: %d}");

    private static Random random = new Random();
    private String data;

    public String getData() {
        String[] parts = data.split("%d");

        return IntStream
                .range(0, parts.length)
                .mapToObj(i -> i < parts.length - 1 ? parts[i] + randomInt() : parts[i])
                .collect(Collectors.joining());
    }

    private int randomInt() {
        return random.nextInt(Integer.MAX_VALUE - 1);
    }
}
