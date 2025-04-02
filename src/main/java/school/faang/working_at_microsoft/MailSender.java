package school.faang.working_at_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static int totalMails = 5;
    private static int mailsPerThread = 1;
    private static int threadCount = (int) Math.ceil((double) totalMails / mailsPerThread);
    private static final List<String> letters = new ArrayList<>(List.of("1st letter", "2nd letter",
            "3rd letter", "4th letter", "5th letter"));

    public static void main(String[] args) {
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new SenderRunnable(i, i));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All letters send");
    }
}
