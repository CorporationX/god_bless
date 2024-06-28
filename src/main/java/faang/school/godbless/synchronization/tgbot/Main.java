package faang.school.godbless.synchronization.tgbot;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    private static final int MESSAGES_COUNT = 100;
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        List<String> messages = generateMessages(MESSAGES_COUNT);

        ExecutorService executorService = Executors.newCachedThreadPool();

        messages.forEach(message -> executorService.execute(() -> {
            try {
                telegramBot.sendMessage(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        executorService.shutdown();
    }

    private static List<String> generateMessages(int messagesCount) {
        if (messagesCount < 1) {
            throw new IllegalArgumentException();
        }

        return IntStream.rangeClosed(1, messagesCount)
                .boxed()
                .map(i -> "Message " + i)
                .toList();
    }
}
