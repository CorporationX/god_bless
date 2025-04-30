package school.faang.telegrambot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(15);

        IntStream.range(0, 100)
                .forEach(i -> executor.submit(() -> telegramBot.sendMessage("Message: " + i)));

        telegramBot.terminatedExecutor(executor);
    }
}