package faang.school.godbless.microsoftagain;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }

        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

