package school.faang.BJS2_60487;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {

        List<Thread> listThreads = new ArrayList<>();

        ArrayList<String> messageBox = new ArrayList<>();
        IntStream.range(0, TOTAL_MESSAGES).forEach(i -> messageBox.add("Email message number %d".formatted(i)));

        IntStream
                .range(0, THREAD_AMOUNT)
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

        System.out.println("All messages have been sent!");
    }
}
