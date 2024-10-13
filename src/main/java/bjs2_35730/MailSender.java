package bjs2_35730;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        int currThread = 0;

        for (int i = 1; i <= 1000; i++) {
            if (i % 200 == 0) {
                int endIndex = i;
                int startIndex = i - 199;

                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                Thread thread = new Thread(senderRunnable);
                threads[currThread] = thread;
                threads[currThread].start();
                currThread++;
            }
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }

        System.out.println("All mails were successfully delivered!");
    }
}
