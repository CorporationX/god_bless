package faang.school.godbless.task.multithreading.work.at.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static final int THREAD_POOL_LIMIT = 5;
    public static final int MAIL_LIMIT_BY_THREAD = 200;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, THREAD_POOL_LIMIT).forEach(i -> {
            int startIndex = MAIL_LIMIT_BY_THREAD * i + 1;
            int endIndex = MAIL_LIMIT_BY_THREAD + startIndex;
            Thread thread = new Thread(() -> {
                new SenderRunnable(startIndex, endIndex).run();
            });
            thread.start();
            threads.add(thread);
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        System.out.println("All message was sends");
    }
}
