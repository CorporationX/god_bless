package school.faang.BJS2_37791_WorkingInMicrosoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        IntStream.iterate(1, startIndex -> startIndex <= 801, startIndex -> startIndex + 200)
                        .forEach(startIndex -> {
                            Thread thread = new Thread(new SenderRunnable(startIndex, startIndex + 199));
                            threads.add(thread);
                            thread.start();
                        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println("\nThreads have finished theirs work!");
    }
}
