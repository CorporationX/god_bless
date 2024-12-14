package school.faang.task_48222;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int j = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(j, j + 200));
            thread.start();
            j = j + 200;
            threads.add(thread);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted: " + thread.getName());
            }
        });
        System.out.println("All threads have completed their tasks.");
    }
}
