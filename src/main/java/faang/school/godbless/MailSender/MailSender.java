package faang.school.godbless.MailSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> listThread = new ArrayList<>(Arrays.asList(
                new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(200, 400)),
                new Thread(new SenderRunnable(400, 600)),
                new Thread(new SenderRunnable(600, 800)),
                new Thread(new SenderRunnable(800, 1000)))
        );
        for (Thread thread : listThread) {
            thread.start();
        }
        try {
            for (Thread thread : listThread) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nВсе письма были отправленны! ");
    }
}
