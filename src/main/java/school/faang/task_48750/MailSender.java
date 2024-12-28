package school.faang.task_48750;

public class MailSender {
    public static void main(String[] args) {
        int totalMails = 1000;
        int threadsCount = 5;
        int emailsPerThread = totalMails / threadsCount;

        Thread[] threads = new Thread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All messages have been successfully sent !");
    }
}
