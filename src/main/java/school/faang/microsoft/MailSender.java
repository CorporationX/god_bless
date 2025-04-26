package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int numberOfThreads = 5;
        int emailsPerThread = totalEmails / numberOfThreads;

        List<Thread> threads = new ArrayList<>();
        IntStream.range(0, numberOfThreads)
                .forEach(i -> {
                    int startIndex = i * emailsPerThread;
                    int endIndex = (i == numberOfThreads - 1) ? totalEmails : (i + 1) * emailsPerThread;
                    SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                    Thread thread = new Thread(senderRunnable, "Thread-" + i);
                    threads.add(thread);
                    thread.start();
                });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Главный поток прерван.");
                return;
            }
        });
        System.out.println("Все письма успешно отправлены!");
    }
}