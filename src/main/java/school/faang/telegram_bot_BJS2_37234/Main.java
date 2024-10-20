package school.faang.telegram_bot_BJS2_37234;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int THREADS_COUNT = 2;
        final int AWAITING_TIME = 3;
        List<String> messages = new ArrayList<>(List.of(
                "Don't forget the meeting at 3 PM.",
                "Lunch is ready in the kitchen.",
                "Call me when you get a chance.",
                "Happy Birthday! Wishing you a fantastic day!",
                "The package has been delivered.",
                "See you at the gym later!",
                "Reminder: Project deadline is tomorrow.",
                "Your order is on its way.",
                "Meeting rescheduled to 4 PM.",
                "Please send the report by noon.",
                "Let's catch up over coffee this weekend.",
                "You have a new friend request.",
                "The server will be down for maintenance tonight.",
                "Congratulations on your promotion!"
        ));

        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (String message : messages) {
            executorService.submit(() -> bot.sendMessage(message));
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("All messages sent successfully.");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}