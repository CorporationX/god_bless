package faang.school.godbless.Task_Working_in_Google;

import java.util.List;
import java.util.ArrayList;

public class MailSender {

    public static final List<Thread> threads = new ArrayList<>();

    public static void runAllThread(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("all 5 threads have done their job");
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = 200 * (i + 1);
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(sender);
            threads.add(thread);
            thread.start();
        }

        runAllThread(threads);

    }

}
