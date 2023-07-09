package faang.school.godbless.sprint_3.multithreading.telegram_bot;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> messages = List.of("Hello", "How are you", "I am fine", "My name is Matt");
        for (int i = 0; i < 4; i++) {
            int index = i;
            executorService.submit(() -> bot.sendMessage(messages.get(index)));
        }
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Задача выполнена");
    }
}
