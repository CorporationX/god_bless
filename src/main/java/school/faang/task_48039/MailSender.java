package school.faang.task_48039;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int allMessages = 1000;
        int availableThreads = 5;
        int bufferSize = allMessages / availableThreads; // 200

        Thread[] threads = new Thread[availableThreads]; // 5

        for (int i = 0; i < availableThreads; i++) { // 0 -> 4 (5)
            int start = i * bufferSize; // 0 * 200, 1 * 200, 2 * 200, 3 * 200, 4 * 200
            int end = (i + 1) * bufferSize; // 1 * 200, 2 * 200, 3 * 200, 4 * 200, 5 * 200
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join(); // метод main() будет ждать конца работы каждого потока
        }

        System.out.print("All threads completed their jobs!");
    }
}
