package faang.school.godbless.BJS223649;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All messages have been sent");
    }
}
