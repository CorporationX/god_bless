package faang.school.godbless.workingInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        int emailsInOneThread = 20;
        for(int i =0; i < threads.length; i++) {
            int startIndex = i * emailsInOneThread + 1;
            int endIndex = (i + 1) * emailsInOneThread;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письма отправлены.");
    }
}