package Multithreading.bc2017;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;

            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
    }
}
