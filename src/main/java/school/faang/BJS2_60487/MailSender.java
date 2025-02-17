package school.faang.BJS2_60487;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        int threadsAmount = 5;
        List<Thread> listThreads = new ArrayList<>();

        CopyOnWriteArrayList<String> messageBox = new CopyOnWriteArrayList<>();
        IntStream.range(0, 1000).forEach(i -> messageBox.add("Email message number %d".formatted(i)));

        IntStream
                .range(0, threadsAmount)
                .forEach(i -> {
                    Thread thread = new Thread(new SenderRunnable("\"Runnable object №%d\""
                            .formatted(i), i * 200, i * 200 + 199, messageBox));

                    listThreads.add(thread);
                    thread.start();
                    System.out.println("Thread named %s started".formatted(thread.getName()));
                });

        listThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        });

        System.out.println("All messages have send!");
    }
}
