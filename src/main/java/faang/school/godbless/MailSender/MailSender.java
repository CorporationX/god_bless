package faang.school.godbless.MailSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> listThread = new ArrayList<>(Arrays.asList(
                new Thread(new SenderRunnable(1, 100)),
                new Thread(new SenderRunnable(100, 200)),
                new Thread(new SenderRunnable(200, 300)),
                new Thread(new SenderRunnable(300, 400)),
                new Thread(new SenderRunnable(500, 600)))
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
