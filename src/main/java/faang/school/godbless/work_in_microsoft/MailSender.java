package faang.school.godbless.work_in_microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];
        int startIndex = 1;
        int endIndex = 100;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SenderRunnable(startIndex * (i + 1), endIndex - i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
