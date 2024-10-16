package school.faang.Mnogopotochka.ParallelismThread;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = 200;
        int numberOfThreads = totalEmails / emailsPerThread;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = startIndex + emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        System.out.println("Все письма успешно отправлены.");
    }
}
