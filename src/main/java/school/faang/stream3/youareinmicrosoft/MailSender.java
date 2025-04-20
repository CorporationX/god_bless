package school.faang.stream3.youareinmicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static List<String> emails = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            emails.add("email #" + i);
        }
        final Thread thread1 = new Thread(new SenderRunnable(0, 199));
        final Thread thread2 = new Thread(new SenderRunnable(200, 399));
        final Thread thread4 = new Thread(new SenderRunnable(600, 799));
        final Thread thread3 = new Thread(new SenderRunnable(400, 599));
        final Thread thread5 = new Thread(new SenderRunnable(800, 999));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread: sending done");
    }
}
