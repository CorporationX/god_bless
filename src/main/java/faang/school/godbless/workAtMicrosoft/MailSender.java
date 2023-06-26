import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 5; i++) {
            SenderRunnable sender = new SenderRunnable(1, 200, i);
            executor.submit(sender);
        }
        executor.shutdown();
        System.out.println("Все письма отправлены");
    }
}
