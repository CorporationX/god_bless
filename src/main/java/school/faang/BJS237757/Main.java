package school.faang.BJS237757;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadPools = 5;
        int batchSize = totalMessages / threadPools;
        Thread[] threads = new Thread[threadPools];
        for (int i = 0; i < threadPools; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " Прерван!");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все задачи выполнены!");
    }
}
