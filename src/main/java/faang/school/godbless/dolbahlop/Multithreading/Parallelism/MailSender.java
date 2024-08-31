package faang.school.godbless.dolbahlop.Multithreading.Parallelism;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        int index = 0;
        for (int i = 0; i < threads.length; i++) {
            SenderRunnable sender = new SenderRunnable(index + 1, index += 200);
            threads[i] = new Thread(sender);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
