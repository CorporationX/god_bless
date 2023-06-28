package faang.school.godbless.youWorkAtMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        final int QUANTITY = 1000;
        final int THREAD_QUANTITY = 5;
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            int startIndex = (QUANTITY / THREAD_QUANTITY) * i + 1;
            int endIndex = (QUANTITY / THREAD_QUANTITY) * (i + 1);

            Thread thread = new Thread(
                    new SenderRunnable(startIndex, endIndex)
            );

            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("--------------------- \nВсе сообщения посланы");
    }
}
