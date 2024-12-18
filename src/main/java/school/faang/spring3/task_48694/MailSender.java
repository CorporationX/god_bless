package school.faang.spring3.task_48694;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args)  {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        IntStream.range(0, threadsCount).forEach(i -> {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        });


        Arrays.stream(threads).forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        System.out.println("Все письма отправлены!");
    }
}
