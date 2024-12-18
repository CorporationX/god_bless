package school.faang.task_48317;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MAX_THREAD = 5;
    private static final int MAX_EMAILS = 1000;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int portion = (MAX_EMAILS / MAX_THREAD) + 1;
        int strartIndx = 0;
        int endIndx;
        for (int i = 0; i < MAX_THREAD; i++) {
            endIndx = strartIndx + portion > MAX_EMAILS ? MAX_EMAILS : strartIndx + portion;
            SenderRunnable senderRunnable = new SenderRunnable(strartIndx, endIndx);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            System.out.println(String.format("Start: %d. End % d", strartIndx, endIndx));
            strartIndx += portion;
        }
        threads.forEach((obj) -> {
            try {
                obj.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("All emails sent.");
    }
}
