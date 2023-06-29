package faang.school.godbless.Bot;

import lombok.SneakyThrows;

import java.time.LocalDateTime;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(LocalDateTime.now());
        for (int i = 0; i < 10; i ++){
            int finalI = i;
            var thread = new Thread(() -> bot.sendMessage(Integer.toString(finalI)));
            thread.start();
            thread.join();
        }
        System.out.println("Done");
    }
}
