package school.faang.sprint3.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        int batch = 200;
        int start = 0;

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(start + 1, start + batch));
            thread.start();

            start += batch;
            list.add(thread);
        }

        for (Thread thread : list) {
            try {
                thread.join();
            } catch (Exception e) {
                System.out.println("Process interrupted");
            }
        }

        System.out.println("All " + counter + " emails are delivered");

    }
}
