package faang.school.godbless.microsoft;

import java.util.List;
import java.util.function.Consumer;

public class MailSender {

    public static void main(String[] args) {
        List<Thread> threads = List.of(
                new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(201, 400)),
                new Thread(new SenderRunnable(401, 600)),
                new Thread(new SenderRunnable(601, 800)),
                new Thread(new SenderRunnable(801, 1000))
        );

        threadSetup(threads, Thread::start);
        threadSetup(threads, thread1 -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка, поток прервали");
            }
        });

        System.out.println("Все письма отправлены");
    }

    private static void threadSetup(List<Thread> threads, Consumer<Thread> consumer) {
        for (Thread thread : threads) {
            consumer.accept(thread);
        }
    }
}
