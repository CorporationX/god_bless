import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            SenderRunnable sender = new SenderRunnable(1, 200, i);
            executor.submit(sender);
        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("Все письма отправлены");
    }
}
