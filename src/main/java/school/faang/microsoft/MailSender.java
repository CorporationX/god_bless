package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int first = i * 200;
            int last = (i + 1) * 200;
            threads[i] = new Thread(new SenderRunnable(first, last));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Успех");
    }
}
