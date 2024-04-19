package faang.school.godbless.you_work_at_microsoft;

public class MailSender {
    public static void main(String[] args) {

        int totalEmails = 1000;
        int numberOfThreads = 5;
        int emailsPerThread = 200;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;
            if (i == numberOfThreads - 1) {
                endIndex = totalEmails;
            }
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все письма успешно отправлены.");
    }
}
