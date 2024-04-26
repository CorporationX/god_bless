package faang.school.godbless.multithreading_parallelism.BJS2_6153;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i = i + 200) {
            threads.add(new Thread(new SenderRunnable(i, i + 199)));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All messages were sent");
    }
}
