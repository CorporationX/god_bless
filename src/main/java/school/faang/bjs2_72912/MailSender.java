package school.faang.bjs2_72912;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class MailSender {
    private int emailTotal;
    private int threadCount;
    private final int batchSize = 200;
    ExecutorService executor;

    public MailSender(int emailTotal) {
        this.emailTotal = emailTotal;
        this.threadCount = calculateThreadCount(emailTotal);
        this.executor = Executors.newFixedThreadPool(threadCount);
    }

    public int calculateThreadCount(int emailTotal) {
        if (emailTotal <= 200) {
            return 1;
        }
        return Math.min(emailTotal / 200, 5);
    }

    public void sendEmails() {
        int batchesCount = (int) Math.ceil((double) emailTotal / batchSize);
        for (int i = 0; i < batchesCount; i++) {
            int startingPoint = i * batchSize;
            int endPoint = Math.min((i + 1) * batchSize, emailTotal);
            executor.execute(new SenderRunnable(startingPoint, endPoint));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("I failed at this task: look for solution");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.getCause();
        }
    }


    public static void main(String[] args) {
        MailSender sender = new MailSender(200000);
        sender.sendEmails();
        System.out.println("Every mail sent");
    }
}
