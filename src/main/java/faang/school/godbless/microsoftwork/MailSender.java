package faang.school.godbless.microsoftwork;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int totalMails = 1000;
        int mailsPerThread = 200;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < totalMails; i += mailsPerThread) {
            int startIndex = i + 1;
            int endIndex = i + mailsPerThread + 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }
        for (var thread : threads) {
            thread.join();
        }
        System.out.println("All mails are sent");
    }
}
