package faang.school.godbless.workAtMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int COUNT_LETTERS = 1000;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList();
        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * (COUNT_LETTERS / COUNT_THREAD);
            int end = (i + 1) * (COUNT_LETTERS / COUNT_THREAD);

            Thread thred = new Thread(new SenderRunnable(start, end));
            thred.start();
            threadList.add(thred);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }
}
