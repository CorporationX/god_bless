package faang.school.godbless.multithreading.microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("\nAll emails are sent successfully! %s\n", Thread.currentThread().getName());
    }
}
