package faang.school.godbless.multithreading_parallelism.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i+1;
            int endIndex = 200 * (i+1);
            SenderRunnable  senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            threadList.add(thread);
            thread.start();
        }

        for(Thread thread: threadList){
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
