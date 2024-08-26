package faang.school.godbless.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable secondSender = new SenderRunnable(0, 200);
        SenderRunnable thirdSender = new SenderRunnable(200, 400);
        SenderRunnable fourthSender = new SenderRunnable(400, 600);
        SenderRunnable fifthSender = new SenderRunnable(600, 800);
        SenderRunnable sixthSender = new SenderRunnable(800, 1000);
        Thread firstThread = new Thread(secondSender);
        Thread secondThread = new Thread(thirdSender);
        Thread thirdThread = new Thread(fourthSender);
        Thread fourthThread = new Thread(fifthSender);
        Thread fifthThread = new Thread(sixthSender);
        List<Thread> threads = new ArrayList<>();
        threads.add(fifthThread);
        threads.add(firstThread);
        threads.add(secondThread);
        threads.add(thirdThread);
        threads.add(fourthThread);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Письма отправлены");
    }
}
