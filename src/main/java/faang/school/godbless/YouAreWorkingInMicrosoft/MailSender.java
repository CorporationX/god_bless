package faang.school.godbless.YouAreWorkingInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int emailsCount = 1000;
        int threatsCount = 5;
        int emailsPerThread = emailsCount / threatsCount;

        Thread[] threads = new Thread[threatsCount];

        for (int i = 0; i < threatsCount; i++) {
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
