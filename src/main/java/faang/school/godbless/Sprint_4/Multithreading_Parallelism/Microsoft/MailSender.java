package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int numberOfMessages = 1000;
        int numberOfThreads = 5;
        int messagesPerThread = numberOfMessages / numberOfThreads;
        List<Thread> threads = new ArrayList<>(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = startIndex + messagesPerThread - 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads.add(i, new Thread(senderRunnable));
            threads.get(i).start();
        }
        threads.stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("All messages sent");
    }
}
