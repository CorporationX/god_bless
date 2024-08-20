package faang.school.godbless.BJS2_23624;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000; // Общее количество писем для отправки
        Thread[] threads = new Thread[5]; // Количество потоков
        int emailsPerThread = totalEmails / threads.length;

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i + 1) * emailsPerThread;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
