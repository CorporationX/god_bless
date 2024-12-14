package faang.school.godbless.task.multithreading.telegram.bot;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_MESSAGES = 50;

    private static final TelegramBot bot = new TelegramBot();

    @SneakyThrows
    public static void main(String[] args) {
        var messages = getMessages();
        long start = System.currentTimeMillis();
        messages.forEach(msg -> log.info(bot.sendMessage(msg)));
        long end = System.currentTimeMillis();
        System.out.println("Time of sending: " + (end - start));
        bot.getScheduler().shutdown();
    }
    private static List<String> getMessages() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_MESSAGES)
                .mapToObj(i -> "Message " + i)
                .toList();
    }
}
