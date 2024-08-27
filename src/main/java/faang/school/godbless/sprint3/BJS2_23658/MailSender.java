package faang.school.godbless.sprint3.BJS2_23658;

public class MailSender {
    public static void main(String[] args) {
        int totalMails = 1000;
        int numberOfThreads = 5;
        int mailsPerThread = totalMails / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * (mailsPerThread + 1);
            int endIndex;
            if (i == numberOfThreads - 1) {
                endIndex = totalMails;
            } else {
                endIndex = startIndex + mailsPerThread - 1;
            }

            threads[i] = new Thread(() -> new SenderRunnable(startIndex, endIndex).run());
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All mails were sent");
    }
}
