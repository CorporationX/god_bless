package school.faang.m1.thread.mail;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        final int totalMails = 1000;
        final int threads = 5;
        final int chunkSize = totalMails / threads;


        Thread[] workers = new Thread[threads];

        for (int t = 0; t < threads; t++) {
            int start = t * chunkSize;
            int end = (t == threads - 1) ? totalMails : start + chunkSize;

            SenderRunnable task = new SenderRunnable(start, end);
            workers[t] = new Thread(task, "Sender-" + (t + 1));
            workers[t].start();
        }

        for (Thread worker : workers) {
            worker.join();
        }

        System.out.println("All mails sent!");
    }
}
