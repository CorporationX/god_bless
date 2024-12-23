package school.faang.task_48715;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = 200;
        int threadCount = totalEmails / emailsPerThread;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = startIndex + emailsPerThread - 1;

            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при ожидании завершения потока: " + e.getMessage());
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
