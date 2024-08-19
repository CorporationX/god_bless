package faang.school.godbless.modul3.workinmicrosoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int N_THREADS = 5;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, N_THREADS)
                .map(startIndex -> startIndex * 200 + 1)
                .forEach(startIndex -> {
                    int endIndex = startIndex + 199;
                    Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
                    thread.start();
                    threads.add(thread);
                });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException();
            }
        });

        System.out.println("All emails have been sent successfully");
    }
}
