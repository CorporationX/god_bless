package school.faang.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int totalMsg = 1000;
        int numberOfThreads = 5;
        int batchSize = totalMsg / numberOfThreads;
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All mails have sent");
    }

}
