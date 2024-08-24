package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int threadsCount = 5;
        int emailsPerThread = totalEmails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("All email sent successfully");
    }
}
