package faang.school.godbless.bjs223836;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;

            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(sender, "Thread-" + (i + 1));
            threads[i].start();
        }

        for (var thread : threads) {
            thread.join();
        }
    }
}