package ru.kraiush.threads.BJS2_24490;

import java.util.Date;

public class AppTelegramBot {

    public static void main(String[] args) throws InterruptedException {

        TelegramBot tb = new TelegramBot(90, new Date());
        for (int i = 0; i < 100; i++) {
            new Thread(tb, String.valueOf(i)).start();
        }
    }
}
