package faang.school.godbless.sprint4.multithreading_parallelism_thread.task1;


import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Done");
    }
}
