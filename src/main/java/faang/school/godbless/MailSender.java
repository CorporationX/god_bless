package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public void sendEmails(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        threadList.add(new Thread(new SenderRunnable(0, 200)));
        threadList.add(new Thread(new SenderRunnable(200, 400)));
        threadList.add(new Thread(new SenderRunnable(400, 600)));
        threadList.add(new Thread(new SenderRunnable(600, 800)));
        threadList.add(new Thread(new SenderRunnable(800, 1000)));

        MailSender sender = new MailSender();
        sender.sendEmails(threadList);

        for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All threads complete sending messages !");
    }
}
