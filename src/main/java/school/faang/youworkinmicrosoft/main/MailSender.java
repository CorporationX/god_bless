package school.faang.youworkinmicrosoft.main;

import school.faang.youworkinmicrosoft.maincode.SenderRunnable;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalCount = 1000;
        int threadCount = 5;
        int batchSize = totalCount / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
