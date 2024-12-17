package school.faang.bjs248233;

public class MailSender {
    public static void main(String[] args) {

        Thread[] threads = new Thread[Constants.THREADS_AMOUNT];
        for (int i = 0; i < Constants.THREADS_AMOUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(i * Constants.CHUNK_SIZE, (i + 1) * Constants.CHUNK_SIZE));
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
