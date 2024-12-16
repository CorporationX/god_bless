package school.faang.task_48222;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int j = 0;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < Constant.THREADS; i++) {
            int end = j + Constant.MAIL_FOR_STEP;
            if (i == Constant.THREADS - 1) {
                end = Constant.SUMMARY_MAIL;
            }

            Thread thread = new Thread(new SenderRunnable(j, end));
            thread.start();
            j = end;
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
