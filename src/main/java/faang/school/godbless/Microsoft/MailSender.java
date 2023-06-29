package faang.school.godbless.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(i * 200 + 1, (i + 1) * 200);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread: threads){

            thread.join();
        }
        System.out.println("Everything sent");
    }
}
