package school.faang.java.thread.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static List<String> listEmails;

    static {
        listEmails = new ArrayList<>();
        for (int counter = 0; counter < 1000; counter++) {
            listEmails.add("Email #" + counter);
        }
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int counter = 0; counter < 5; counter++) {
            threadList.add(new Thread(new SenderRunnable(200 * counter, 200 * (counter + 1) - 1)));
            threadList.get(counter).start();
        }

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("\nAll 1000 Emails sent");
    }
}