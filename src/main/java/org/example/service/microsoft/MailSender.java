package org.example.service.microsoft;

import org.example.model.microsoft.SenderRunnable;

public class MailSender {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new SenderRunnable(0, 200));
        Thread secondThread = new Thread(new SenderRunnable(200, 400));
        Thread thirdThread = new Thread(new SenderRunnable(400, 600));
        Thread fourthThread = new Thread(new SenderRunnable(600, 800));
        Thread fifthThread = new Thread(new SenderRunnable(800, 1000));

        try {
            firstThread.start();
            firstThread.join();

            secondThread.start();
            secondThread.join();

            thirdThread.start();
            thirdThread.join();

            fourthThread.start();
            fourthThread.join();

            fifthThread.start();
            fifthThread.join();

            System.out.println("Success sent all mail notifications!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
