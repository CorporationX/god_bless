package faang.school.godbless.BJS2_5662;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 3 + 1;
            int endIndex = startIndex + 3;

            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
            System.out.println(i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
