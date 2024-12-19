package school.faang.task_48698;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int numberOfEmails = 1000;
        int threadsCount = 5;
        int groupSize = numberOfEmails / threadsCount;

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * groupSize;
            int endIndex = groupSize * (i + 1);
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("\nВсе письма отправлены!!!");
    }
}
