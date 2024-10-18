package school.faang.godbless.bjs2_37771;

public class MailSender {
    public static void sendMail(int threadsNumber, int mailNumber) throws InterruptedException {
        int batch = mailNumber / threadsNumber;
        int startIndex = 0;
        Thread[] threads = new Thread[threadsNumber];
        for (int countThreads = 0; countThreads < threadsNumber - 1; countThreads++) {
            int endIndex = startIndex + batch;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[countThreads] = thread;
            thread.start();
            startIndex = endIndex;
        }
        Thread lastThread = new Thread(new SenderRunnable(startIndex, mailNumber));
        lastThread.start();
        threads[threadsNumber - 1] = lastThread;
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All mail is sent");
    }
}
