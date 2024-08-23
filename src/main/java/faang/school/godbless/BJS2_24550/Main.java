package faang.school.godbless.BJS2_24550;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1, 100).forEach(i -> executor.execute(() ->
                bot.sendMessage(Integer.toString(i))
        ));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Все сообщения отправлены!");
    }
}
