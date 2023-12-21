package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmail = 1000;
        int amountThread = 9;

        int startIndex = 1;
        int endIndex = totalEmail / amountThread;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < amountThread; i++) {
            if (i == amountThread - 1) {
                endIndex = totalEmail;
            }
            Thread thread = new Thread(new SenderRunnable(new StackMail(startIndex, endIndex)));
            threads.add(thread);
            startIndex = endIndex + 1;
            endIndex = totalEmail / amountThread + endIndex;
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All emails were sent!");
    }
}
