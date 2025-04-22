package school.faang.stream3.parallelismthread.workformicrosoft;

import java.util.Random;

public class RandomStringGenerator {
    private static final Random RANDOM = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (RANDOM.nextInt(95) + 32);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
