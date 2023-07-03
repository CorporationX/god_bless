package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MainTelegramBot {
    public static void main(String[] args) {
        TelegramBot bot1 = new TelegramBot(0,0);

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> bot1.sendMessage(Thread.currentThread().getId() + " Misha"));
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
