package faang.school.godbless.telegramBot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        TelegramBot bot1 = new TelegramBot(5, new Date());
        TelegramBot bot2 = new TelegramBot(5, new Date());
        TelegramBot bot3 = new TelegramBot(5, new Date());
        TelegramBot bot4 = new TelegramBot(5, new Date());
        List<TelegramBot> bots = new ArrayList<>();
        bots.add(bot1);
        bots.add(bot2);
        bots.add(bot3);
        bots.add(bot4);

        for (TelegramBot bot : bots) {
            executor.submit(bot::sendMessage);
        }
        executor.shutdown();
        try {
            if(executor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("Задача выполнена");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
