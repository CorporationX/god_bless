package Multithreading_youAreWorkingMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        addLettersForProcessing(1000);

        long start = System.currentTimeMillis();
        THREADS.forEach(thread -> thread.start());
        THREADS.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Все письма успешно обработаны! Это заняло - " +
                (System.currentTimeMillis() - start) + " мс");
    }

    private static void addLettersForProcessing(int lettersCount) {
        int countIteration = lettersCount / 200;
        for (int i = 0; i < countIteration; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            THREADS.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }
    }
}
