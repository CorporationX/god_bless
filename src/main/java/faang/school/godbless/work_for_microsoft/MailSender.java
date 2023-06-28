package faang.school.godbless.work_for_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(i*200, i*200 + 200));
            thread.start();
            threads.add(thread);
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All messages delivered!");
    }
}
