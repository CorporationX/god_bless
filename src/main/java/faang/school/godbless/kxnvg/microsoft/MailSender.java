package faang.school.godbless.kxnvg.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = startIndex + 199;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads.add(new Thread(senderRunnable));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отпрпвлены");
    }
}
