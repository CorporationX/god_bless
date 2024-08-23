package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        int totalMessages = 10;
        int threadsCount = 5;
        int messagesPerThread = totalMessages / threadsCount;

        // Создание и запуск потоков
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = startIndex + messagesPerThread;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable, "Thread-" + (i + 1));
            threads[i].start();
        }
        // Ожидание завершения работы всех потоков
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}