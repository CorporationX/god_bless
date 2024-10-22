package youWorkMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        int countThread = 5;
        int numbedMessages = 1000000;

        for (int i = 0; i < countThread; i++) {
            int range = numbedMessages / countThread;
            SenderRunnable senderRunnable = new SenderRunnable(i * range + 1, (i + 1) * range);
            Thread thread = new Thread(senderRunnable);
            THREADS.add(thread);
            thread.start();
        }

        THREADS.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
