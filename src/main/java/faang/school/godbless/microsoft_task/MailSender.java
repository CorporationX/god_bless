package faang.school.godbless.microsoft_task;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Messages sent successfully!");
    }
}