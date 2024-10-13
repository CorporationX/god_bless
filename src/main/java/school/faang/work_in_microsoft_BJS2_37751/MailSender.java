package school.faang.work_in_microsoft_BJS2_37751;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int threadAmount = 5;
        int listSize = 1000;
        int batchSize = listSize / threadAmount;

        for (int i = 0; i < threadAmount; i++) {
            int start = i * batchSize;
            int end = i * batchSize + batchSize;
            Thread thread = new Thread(new SenderRunnable(start, end));
            thread.start();
            thread.join();
        }
        System.out.println("All messages have been sent");
    }
}
