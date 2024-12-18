package school.faang.bjs248386;

public class MailSender {
    public static void main(String[] args) {

        int totalMessage = 1000;
        int threadCount = 5;
        int batchSize = totalMessage / threadCount;

        Thread[] threads = new Thread[threadCount];
        int start;
        int end;
        for (int i = 0; i < threads.length; i++) {
            start = i * batchSize;
            end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Ishlar tugadi");
    }
}
