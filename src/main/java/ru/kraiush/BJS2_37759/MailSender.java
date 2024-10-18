package ru.kraiush.BJS2_37759;

public class MailSender {
    public static void main(String[] args) {
        int mailsQuantity = 1000;
        int threadsQuantity = 5;
        int batchSize = mailsQuantity / threadsQuantity;

        Thread[] threads = new Thread[threadsQuantity];

        for (int i = 0; i < threadsQuantity; ++i) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All emails were sent!");
    }
}
