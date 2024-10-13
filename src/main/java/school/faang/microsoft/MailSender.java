package school.faang.microsoft;
public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] arrayThread = new Thread[threadsCount];
        for(int i = 0; i < threadsCount; i++) {
            Integer startIndex = batchSize * i;
            Integer endIndex = batchSize * (1 + i);
            arrayThread[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            arrayThread[i].start();
        }

        for(Thread thread : arrayThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены!");
    }
}