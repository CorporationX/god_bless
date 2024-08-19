package faang.school.godbless.BJS2_23624;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000; // Общее количество писем для отправки
        int threadsCount = 5; // Количество потоков
        int emailsPerThread = totalEmails / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = (i + 1) * emailsPerThread - 1;

            Thread senderThread = new Thread(new SenderRunnable(startIndex, endIndex));
            senderThread.start();
        }
    }
}
