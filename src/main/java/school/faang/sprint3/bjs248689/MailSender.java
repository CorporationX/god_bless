package school.faang.sprint3.bjs248689;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;
        int start, end;

        Thread[] threads = new Thread[threadsCount];

        try {
            for (int i = 0; i < threadsCount; i++) {
                start = i * batchSize;
                end = (i + 1) * batchSize;
                threads[i] = new Thread(new SenderRunnable(start, end));
                threads[i].start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("\nВсе письма успешно отправлены.");
        } catch (InterruptedException e) {
            System.err.println("Поток был прерван: ");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка");
        }
    }
}