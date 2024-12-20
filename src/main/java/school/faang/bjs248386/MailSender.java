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

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Ishlar tugadi");
    }
}
