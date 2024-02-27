package multithreadingPart1.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final int BATCH = 200;
    public static final int THREADAMOUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADAMOUNT; i++) {
            int startIndex = i * BATCH;
            int endIndex = startIndex + BATCH;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Письма все отправлены");
    }
}
