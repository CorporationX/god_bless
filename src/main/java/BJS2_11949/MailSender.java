package BJS2_11949;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int batchSize = 200;
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = batchSize * i;
            int endIndex = startIndex + batchSize;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все сообщения отправлены");
    }
}
