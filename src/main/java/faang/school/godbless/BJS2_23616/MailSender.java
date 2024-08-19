package faang.school.godbless.BJS2_23616;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int THREAD_AMOUNT = 5;
    private static final int LETTER_AMOUNT = 1000;

    public static void main(String[] args) {
        int amountEmailsInThread = LETTER_AMOUNT / THREAD_AMOUNT;
        List<Thread> threads = IntStream.range(0, THREAD_AMOUNT)
                .mapToObj(num -> new SenderRunnable(num * amountEmailsInThread, (num + 1) * amountEmailsInThread))
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread Error");
            }
        });
        System.out.println("All emails have been sent");
    }
}


