package faang.school.godbless.working.at.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        List<String> mails = new ArrayList<>(1000);
        for (int i = 1; i <= 1000; i++) {
            mails.add("Mail" + i);
        }

        int blockSize = 200;
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < mails.size(); i += blockSize) {
            int end = Math.min(i + blockSize, mails.size());
            List<String> block = new ArrayList<>(mails.subList(i, end));
            SenderRunnable senderRunnable = new SenderRunnable(block);
            executor.submit(senderRunnable);
        }

        executor.shutdown();

    }
}
