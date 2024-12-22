package school.faang.task_48691;

public class MailSender {
    public static void main(String[] args) {

        int threadCount = 5;
        int mails = 1000;
        int batchSize = mails / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

    }
}
