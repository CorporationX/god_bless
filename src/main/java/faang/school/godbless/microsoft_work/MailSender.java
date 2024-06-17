package faang.school.godbless.microsoft_work;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {
        List<Thread> threadPool = new ArrayList<>();

        System.out.println("Mail sending starts");
        int numberOfTasksPerThread = NUMBER_OF_TASKS / NUMBER_OF_THREADS;

        for (int i = 0; i < NUMBER_OF_TASKS; i += numberOfTasksPerThread) {
            Thread mailSenderThread = new Thread(new SenderRunnable(i, i + numberOfTasksPerThread));
            threadPool.add(mailSenderThread);
            mailSenderThread.start();
        }

        for (Thread currentMailSenderThread : threadPool) {
            try {
                currentMailSenderThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All mails have been sent");
    }
}
