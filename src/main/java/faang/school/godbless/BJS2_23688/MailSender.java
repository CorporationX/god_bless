package faang.school.godbless.BJS2_23688;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmails = 1000;
        int emailsPerThread = totalEmails / 5;
        var threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i + 1) * emailsPerThread;
            var senderRunnable = new SenderRunnable(startIndex, endIndex);

            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
                thread.join();
        }

        System.out.println("All emails have been successfully sent!");
    }
}
