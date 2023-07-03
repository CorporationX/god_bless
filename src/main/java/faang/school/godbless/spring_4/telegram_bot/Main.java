package faang.school.godbless.spring_4.telegram_bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static ExecutorService POOL = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {

        TelegramBot botEvgen = new TelegramBot(0, System.currentTimeMillis());

        TelegramBot botStepan = new TelegramBot(0, System.currentTimeMillis());


        String msg = "Two roads diverged in a yellow wood,\n" +
                "And sorry I could not travel both\n" +
                "And be one traveler, long I stood\n" +
                "And looked down one as far as I could\n" +
                "To where it bent in the undergrowth.\n" +
                "\n" +
                "Then took the other, as just as fair,\n" +
                "And having perhaps the better claim,\n" +
                "Because it was grassy and wanted wear;\n" +
                "Though as for that the passing there\n" +
                "Had worn them really about the same.\n" +
                "\n" +
                "And both that morning equally lay\n" +
                "In leaves no step had trodden black.\n" +
                "Oh, I kept the first for another day!\n" +
                "Yet knowing how way leads on to way,\n" +
                "I doubted if I should ever come back.";

        String[] message = msg.split(" ");

        newBot(botEvgen, message);

        // newBot(botStepan, message);

        POOL.shutdown();

        while (!POOL.isTerminated()) {
        }
    }

    private static void newBot(TelegramBot bot, String[] message) {
        for (String s : message) {
            POOL.submit(() -> {
                try {
                    bot.sendMessage(s);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
