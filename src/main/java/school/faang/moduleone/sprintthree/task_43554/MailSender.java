package school.faang.moduleone.sprintthree.task_43554;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end;
            if (i == threadsCount - 1) {
                end = totalMessages;
            } else {
                end = (i + 1) * batchSize;
            }
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письма отправлены");
    }
}
