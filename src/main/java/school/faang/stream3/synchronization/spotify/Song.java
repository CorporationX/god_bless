package school.faang.stream3.synchronization.spotify;

import lombok.ToString;

import java.util.Random;

@ToString
public class Song {
    private static final Random RANDOM = new Random();
    private static final int NAME_LENGTH = 5;
    private static final int LOWER_BOUND = 32;
    private static final int BOUND_DIFFERENCE = 95;

    private String name;

    public Song() {
        name = createName();
    }

    private String createName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NAME_LENGTH; i++) {
            char randomChar = (char) (RANDOM.nextInt(BOUND_DIFFERENCE) + LOWER_BOUND);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
