package school.faang.iworkinmicrosoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {

        List<String> emails = new ArrayList<String>(Collections.nCopies(1000, " -> one more e-mail!"));

        int threadCount = 5;
        int threadLimit = emails.size() / threadCount;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * threadLimit;
            int endIndex = (i == threadCount - 1) ? emails.size() - 1 : startIndex + threadLimit - 1;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex, emails));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted" + thread.getName());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
