package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int threadsCount = 5;
        int emailsPerThread = totalEmails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * emailsPerThread;
            int end = (i + 1) * emailsPerThread;
            SenderRunnable sender = new SenderRunnable(start, end);
            threads[i] = new Thread(sender, "Поток-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при ожидании потока: " + e.getMessage());
            }
        }

        System.out.println("Все письма были успешно отправлены!");
    }
}