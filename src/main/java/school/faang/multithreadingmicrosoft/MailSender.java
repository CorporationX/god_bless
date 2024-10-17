package school.faang.multithreadingmicrosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int totalMails = 1000;
        int quantityThread = 5;
        int packet = totalMails / quantityThread;

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < quantityThread; i++) {
            threadList.add(new Thread(
                    new SenderRunnable(i * packet, (i + 1) * packet)
            ));
            threadList.get(i).start();
        }

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
            System.out.println("All sent!!!");
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
