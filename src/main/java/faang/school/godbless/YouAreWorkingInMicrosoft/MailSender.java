package faang.school.godbless.YouAreWorkingInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int Emails = 1000;
        int Threats = 5;
        int emailsPerThread = Emails / Threats;

        Thread[] threads = new Thread[Threats];

        for (int i = 0; i < Threats; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);

            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All emails sent");


    }
}
