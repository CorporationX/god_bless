package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MailSender {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }

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
