package faang.school.godbless.microsoft;


import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        int threadAmount = 5;
        int batchSize = 200;

        for (int i = 0; i < threadAmount; i++) {
            int indexStart = i * batchSize;
            int indexEnd = indexStart + batchSize;
            Thread thread = new Thread(new SenderRunnable(indexStart, indexEnd));
            threads.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            System.out.println("Encountered an exception: ");
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
