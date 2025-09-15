package school.faang.bsj2_89900;

public class Main {
    private static final int MESSAGES_COUNT = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        int packageSize = MESSAGES_COUNT / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * packageSize;
            int endIndex = (i + 1) * packageSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
