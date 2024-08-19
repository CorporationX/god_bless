package work.in.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MAILS_CHUNK = 200;
    private static final int THREAD_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < THREAD_SIZE; i++) {
            int startIndex = i * MAILS_CHUNK;
            Thread sentThread = new Thread(new SenderRunnable(startIndex, startIndex + MAILS_CHUNK));
            sentThread.start();
            threads.add(sentThread);
        }

        threads.forEach(tr -> {
            try {
                tr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Все письма были отправлены");
    }
}
