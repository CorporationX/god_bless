package faang.school.godbless.bjs2_23696;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    private static final int EMAILS_AMOUNT = 25;
    private static final int THREADS_AMOUNT = 5;
    private static final int EMAILS_PER_THREAD = EMAILS_AMOUNT / THREADS_AMOUNT;

    private static List<String> emails;
    private static List<Thread> threadPool;

    public static void main(String[] args) throws InterruptedException {
        emails = generateEmails();
        threadPool = new ArrayList<Thread>(THREADS_AMOUNT);

        IntStream.rangeClosed(0, THREADS_AMOUNT - 1)
                .forEach(i -> {
                    int startIndex = i * EMAILS_PER_THREAD;
                    int endIndex = (i + 1) * EMAILS_PER_THREAD - 1;
                    List<String> emailsForThread = defineEmailsForThread(startIndex, endIndex, emails);
                    SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex, emailsForThread, i + 1);
                    Thread newThread = new Thread(senderRunnable);
                    threadPool.add(newThread);
                    newThread.start();
                });

        threadPool.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("All emails have been sent");
    }

    private static List<String> defineEmailsForThread(int startIndex, int endIndex, List<String> emails) {
        return IntStream.rangeClosed(startIndex, endIndex)
                .mapToObj(emails::get)
                .toList();
    }

    private static List<String> generateEmails() {
        return IntStream.rangeClosed(1, EMAILS_AMOUNT)
                .mapToObj(n -> "Email #" + n)
                .toList();
    }
}
