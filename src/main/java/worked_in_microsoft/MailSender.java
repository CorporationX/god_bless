package worked_in_microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        int totalMails = 1000;
        int totalThreads = 5;
        int batch = totalMails / totalThreads;
        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);
        IntStream.range(0, batch).forEach(i -> {
            int startIndex = i * (totalMails / batch);
            int endIndex = (i + 1) * (totalMails / batch);
            executor.submit(new SenderRunnable(startIndex, endIndex));
        });
        executor.shutdown();
        System.out.println("Все письма успешно отправлены!");
        }
    }
