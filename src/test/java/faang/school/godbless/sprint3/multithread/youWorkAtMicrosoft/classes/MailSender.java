package faang.school.godbless.sprint3.multithread.youWorkAtMicrosoft.classes;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200;
            SenderRunnable sender = new SenderRunnable(startIndex, startIndex + 200);
            Thread thread = new Thread(sender);
            list.add(thread);
            thread.start();
        }

        list.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Done");
    }
}