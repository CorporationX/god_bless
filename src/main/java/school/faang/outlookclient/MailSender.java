package school.faang.outlookclient;

public class MailSender {

    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = 200;
        int numberOfThreads = totalEmails / emailsPerThread;

        Thread[] threads = new Thread[numberOfThreads];
        int startIndex = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int endIndex = startIndex + emailsPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            startIndex = endIndex;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All emails have been sent successfully!");
    }
}
