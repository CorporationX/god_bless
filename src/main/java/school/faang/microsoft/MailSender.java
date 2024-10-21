package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMails = 1000, threadsNumber = 5;
        int batchSize = totalMails / threadsNumber;

        Thread[] threads = new Thread[threadsNumber];

        for(int i = 0; i < threadsNumber; i++) {
            int start = batchSize * i;
            int end = batchSize + start;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (int i = 0; i < threadsNumber; i++) { threads[i].join(); }

        System.out.println("All mails were sent");
    }
}
