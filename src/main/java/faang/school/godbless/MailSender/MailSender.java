package faang.school.godbless.MailSender;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> listThread = new ArrayList<>();
        for (int i = 1, indexTwo = 1; i <= 5; i++) {
            listThread.add(new Thread(new SenderRunnable(indexTwo, 200 * i)));
            indexTwo = 200 * i;
        }
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
