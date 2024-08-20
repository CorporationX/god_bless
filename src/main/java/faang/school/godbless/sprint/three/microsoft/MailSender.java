package faang.school.godbless.sprint.three.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String... args) {
        int batchMails = Constants.MAILS_IN_QUEUE / Constants.ACTIVE_THREADS;
        List<Thread> executingThreads = new ArrayList<>();

        for (int i = 0; i < Constants.ACTIVE_THREADS; i++) {
            int startIndex = i * batchMails + 1;
            int endIndex = startIndex + batchMails;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            executingThreads.add(thread);
        }

        executingThreads.forEach(thread -> {
                            try {
                                thread.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });

        System.out.println("Finish");
    }
}
