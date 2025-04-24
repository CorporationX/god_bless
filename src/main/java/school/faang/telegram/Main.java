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

    private static final int SERVICE_THREAD_POOL_SIZE = 2;
    private static final int INCOME_THREAD_POOL_SIZE = 5;
    private static final int MOCK_MESSAGE_COUNT = 100;
    private static final int EXECUTOR_TERMINATION_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService sendServiceExecutor = Executors.newFixedThreadPool(SERVICE_THREAD_POOL_SIZE);
        sendServiceExecutor.submit(new SendService("Send service #1", telegramBot)::activateService);
        sendServiceExecutor.submit(new SendService("Send service #2", telegramBot)::activateService);

        ExecutorService incomeExecutor = Executors.newFixedThreadPool(INCOME_THREAD_POOL_SIZE);
        for (Message message : getMessagesData()) {
            incomeExecutor.submit(() -> telegramBot.sendMessage(message));
        }

        WaitUtils.shutdownExecutorWithWait(incomeExecutor, EXECUTOR_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES);
        WaitUtils.shutdownExecutorWithWait(sendServiceExecutor, EXECUTOR_TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES);
        log.info("Task is complete!");
    }

    private static List<Message> getMessagesData() {
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < MOCK_MESSAGE_COUNT; i++) {
            messages.add(new Message("Message #%d".formatted(i + 1)));
        }
        return messages;
    }
}
