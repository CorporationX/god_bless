package faang.school.godbless.multithreading.telegram;

import java.time.format.DateTimeFormatter;

public class Telegram {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

        for (int i = 0; i < 7; i++) {
            String threadName = "Thread #" + (i + 1);
            String message = "Message #" + (i + 1) + " from " + threadName;

            new Thread(
                    () -> {
                        bot.sendMessage(message);
                        System.out.println("Bot request counter: " + bot.getRequestCounter());
                        System.out.println("Bot last request time: " + bot.getLastRequestTime().format(formatter));
                    },
                    threadName
            ).start();

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
