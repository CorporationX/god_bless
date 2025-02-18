package school.faang.workinmicrosoft;

public class MailSender {
    public static void main(String[] args) {
        int mails = 1000;
        int threadCounter = 5;
        int mailsToThread = mails / threadCounter;
        Thread[] threads = new Thread[threadCounter];
        for (int i = 0; i < threadCounter; i++) {
            int start = i * mailsToThread;
            threads[i] = new Thread(new SenderRunnable(start, start + mailsToThread));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.printf("thread finished");
            } catch (InterruptedException e) {
                System.out.printf("Exception on thread");
            }
        }
        System.out.printf("Main thread is finished");
    }


}

