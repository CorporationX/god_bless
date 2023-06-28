package faang.school.godbless.youWorkAtMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final int QUANTITY = 1000;
        final int THREADQUANITY = 5;
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREADQUANITY; i++) {
            int startIndex = (QUANTITY / THREADQUANITY) * i + 1;
            int endIndex = (QUANTITY / THREADQUANITY) * (i + 1);

            Thread thread = new Thread(
                    new SenderRunnable(startIndex, endIndex)
            );

            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
            thread.join();
        }

        System.out.println("--------------------- \nВсе сообщения посланы");
    }
}
