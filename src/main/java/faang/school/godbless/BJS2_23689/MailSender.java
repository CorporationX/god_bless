package faang.school.godbless.BJS2_23689;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) {
        Thread firstThread = new Thread(
                () -> {
                    SenderRunnable secondPoolEmail = new SenderRunnable(0, 200);
                    for (int i = secondPoolEmail.getStartIndex(); i < secondPoolEmail.getEndIndex(); i++) {
                        secondPoolEmail.run();
                    }
                }

        );
        firstThread.start();

        Thread secondThread = new Thread(
                () -> {
                    SenderRunnable secondPoolEmail = new SenderRunnable(200, 400);
                    for (int i = secondPoolEmail.getStartIndex(); i < secondPoolEmail.getEndIndex(); i++) {
                        secondPoolEmail.run();
                    }
                }

        );
        secondThread.start();

        Thread thirdThread = new Thread(
                () -> {
                    SenderRunnable secondPoolEmail = new SenderRunnable(400, 600);
                    for (int i = secondPoolEmail.getStartIndex(); i < secondPoolEmail.getEndIndex(); i++) {
                        secondPoolEmail.run();
                    }
                }

        );
        thirdThread.start();

        Thread fourthThread = new Thread(
                () -> {
                    SenderRunnable secondPoolEmail = new SenderRunnable(600, 800);
                    for (int i = secondPoolEmail.getStartIndex(); i < secondPoolEmail.getEndIndex(); i++) {
                        secondPoolEmail.run();
                    }
                }

        );
        fourthThread.start();

        Thread fifthThread = new Thread(
                () -> {
                    SenderRunnable secondPoolEmail = new SenderRunnable(800, 1000);
                    for (int i = secondPoolEmail.getStartIndex(); i < secondPoolEmail.getEndIndex(); i++) {
                        secondPoolEmail.run();
                    }
                }

        );
        fifthThread.start();

        try {
            firstThread.join();
            secondThread.join();
            thirdThread.join();
            fourthThread.join();
            fifthThread.join();
            System.out.println("Все сообщения отправлены");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
