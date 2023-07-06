package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MainTelegramBot {
    public static void main(String[] args) {
        TelegramBot bot1 = new TelegramBot(System.currentTimeMillis(),0);

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                try {
                    bot1.sendMessage(Thread.currentThread().getName() + " Misha");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread: threadList){
            try{
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("All messages have been sent !");
    }
}
