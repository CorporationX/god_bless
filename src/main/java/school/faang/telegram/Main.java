package school.faang.telegram;

import lombok.extern.slf4j.Slf4j;
import school.WaitUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int MOCK_MESSAGES_COUNT = 100;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Message message : getMessagesData()) {
            executorService.submit(() -> telegramBot.sendMessage(message));
        }
        WaitUtils.shutdownExecutorWithWait(executorService, 1, TimeUnit.MINUTES);
    }

    private static List<Message> getMessagesData() {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < MOCK_MESSAGES_COUNT; i++) {
            messages.add(new Message("Message #%d".formatted(i + 1)));
        }
        return messages;
    }
}