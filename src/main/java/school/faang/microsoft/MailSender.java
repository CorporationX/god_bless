package school.faang.microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new SenderRunnable(1, 200));

        Thread firstThread = new Thread(new SenderRunnable(1, 200));
        Thread secondThread = new Thread(new SenderRunnable(1, 200));
        Thread thirdThread = new Thread(new SenderRunnable(1, 200));
        Thread fourthThread = new Thread(new SenderRunnable(1, 200));
        Thread fifthThread = new Thread(new SenderRunnable(1, 200));

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();

        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            fifthThread.join();
            System.out.println("Все письма отправлены");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
