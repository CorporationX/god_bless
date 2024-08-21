package faang.school.godbless.bjs2_23696;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int EMAILS_AMOUNT = 25;
    private static final int THREADS_AMOUNT = 5;
    private static final int EMAILS_PER_THREAD = EMAILS_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) throws InterruptedException {
        List<String> emails = generateEmails();

        Thread[] threadPool = new Thread[THREADS_AMOUNT];

        IntStream.rangeClosed(0, THREADS_AMOUNT - 1)
                .forEach(i -> {
                    int startIndex = i * EMAILS_PER_THREAD;
                    int endIndex = (i + 1) * EMAILS_PER_THREAD - 1;
                    SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex, emails, i + 1);
                    threadPool[i] = new Thread(senderRunnable);
                    threadPool[i].start();
                });

        System.out.println("Message before all emails have been sent");

        for (Thread thread : threadPool) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All emails have been sent");
    }

    private static List<String> generateEmails() {
        return IntStream.rangeClosed(1, EMAILS_AMOUNT)
                .mapToObj(n -> "Email #" + n)
                .toList();
    }
}
