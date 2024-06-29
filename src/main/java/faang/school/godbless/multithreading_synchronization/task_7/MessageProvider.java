package faang.school.godbless.multithreading_synchronization.task_7;

import java.util.Random;

public class MessageProvider {
    private static final Random random = new Random();

    private static final String[] MESSAGES = {
            "Hello World!",
            "Welcome!",
            "Good luck!",
            "Stay Positive!",
            "You are awesome!"
    };

    public static String getRandomMessage() {
        return MESSAGES[random.nextInt(MESSAGES.length)];
    }
}
