package school.faang.sender;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    private static final Logger logger = Logger.getLogger(MailSender.class.getName());

    public static void main(String[] args) {
        int allMessage = 1000;
        int threadNumber = 5;
        int size = allMessage / threadNumber;
        Thread[] threads = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(new SenderRunnable(i * size + 1, (i + 1) * size));
            threads[i].start();
        }

        for (Thread thread : threads) {
            if (thread != null) {
                try {
                    thread.join(1000);
                } catch (InterruptedException e) {
                    logger.log(
                            Level.SEVERE,
                            "Ошибка при ожидании завершения потока" +
                                    thread.getName(), e
                    );
                }
            }
        }
        System.out.println("Все письма отправлены");

    }
}
