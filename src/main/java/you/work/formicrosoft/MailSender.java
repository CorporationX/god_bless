package you.work.formicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int emailsNumber = 1000;
        int batchSize = 200;
        int startIndex = 1;
        int endIndex;

        List<Thread> threads = new ArrayList<>();
        while (emailsNumber > 0) {
            if (emailsNumber < batchSize) {
                batchSize = emailsNumber;
            }
            emailsNumber -= batchSize;
            endIndex = startIndex + batchSize - 1;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            System.out.println("Отправляются письма " + startIndex + " - " + endIndex);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();

            startIndex += batchSize;
        }

        for (Thread thread: threads) thread.join();

        System.out.println("Отправка писем завершена");
    }
}
