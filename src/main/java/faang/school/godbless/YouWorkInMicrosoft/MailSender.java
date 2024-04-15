package faang.school.godbless.YouWorkInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int start = i * 200 + 1;
            int end = start + 200;
            threads.add(new Thread(new SenderRunnable(start, end)));
        }

        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
