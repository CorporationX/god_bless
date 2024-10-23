package school.faang.bjs2_37834;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int startIndex = 1;
        int endIndex = 200;
        for (int i = 0; i < 5; i++) {
             threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
            startIndex += 200;
            endIndex += 200;

        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("successful completion");
    }
}
