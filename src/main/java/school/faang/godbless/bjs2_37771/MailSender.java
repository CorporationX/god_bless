package school.faang.godbless.bjs2_37771;


import java.util.Arrays;

public class MailSender {
    public static void main(String[] args) {
        final int threadsNumber = 5;
        final int mailNumber = 202;
        sendMail(threadsNumber, mailNumber);
    }

    private static void sendMail(int threadsNumber, int mailNumber) {
        int batch = mailNumber / threadsNumber;
        int lastBatch = mailNumber % threadsNumber == 0 ? 0 : mailNumber % batch;
        int startIndex = 0;
        Thread[] threads = new Thread[threadsNumber];
        for (int countThreads = 0; countThreads < threadsNumber; countThreads++) {
            int endIndex = startIndex + batch;
            if (countThreads == threadsNumber - 1) {
                endIndex += lastBatch;
            }
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[countThreads] = thread;
            thread.start();
            startIndex = endIndex;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All mail is sent");
    }
}
