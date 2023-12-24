package faang.school.godbless.BJS2_994;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int start = i * 200 + 1;
            int end = start + 200;
            SenderRunnable senderRunnable = new SenderRunnable(start, end);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("fault in thread.join");
            }
        }
        System.out.println("All messages was sended");
    }
}
