package school.faang.microsoft3sprint;

public class MaleSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException exceptionObject) {
            System.out.println("Catched InterruptedException");
        }

        System.out.println("Все потоки завершили работу.");
    }
}
