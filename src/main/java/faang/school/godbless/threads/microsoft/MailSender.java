package faang.school.godbless.threads.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все сообщения отправлены!");
    }
}
