package faang.school.godbless.multithreading.microsoft;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = IntStream.range(0, 5)
                .mapToObj(i -> new Thread(
                        new SenderRunnable(i * 10 + 1, (i * 10 + 1) + 10),
                        "Sender-" + (i + 1)))
                .peek(Thread::start)
                .toList();

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All messages have been successfully sent");
    }
}
