package school.faang.stream3.synchronization.spotify;

import java.util.Random;

public class Song {
    private static final Random RANDOM = new Random();

    private String name;

    public Song() {
        name = createName();
    }

    private String createName() {
        StringBuilder stringBuilder = new StringBuilder();
        int nameLength = 5;
        for (int i = 0; i < nameLength; i++) {
            char randomChar = (char) (RANDOM.nextInt(95) + 32);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
