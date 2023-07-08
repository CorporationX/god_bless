package faang.school.godbless.sprint4_multithreading.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200;
            int endIndex = startIndex + 200;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thr = new Thread(senderRunnable);
            thr.start();
            thr.join();
        }
    }
}
