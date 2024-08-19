package faang.school.godbless.BJS2_23616;

import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Runnable> tasks = Arrays.asList(
                new SenderRunnable(0, 200),
                new SenderRunnable(200, 400),
                new SenderRunnable(400, 600),
                new SenderRunnable(600, 800),
                new SenderRunnable(800, 1000)
        );

        List<Thread> threads = tasks.stream()
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread error");
            }
        });

        System.out.println("All emails have been sent");
    }
}


