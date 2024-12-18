package school.faang.bjs248386;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int totalMessage = 1000;
        int threadCount = 5;
        int batchSize = totalMessage / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threads.length; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Ishlar tugadi");
    }
}
