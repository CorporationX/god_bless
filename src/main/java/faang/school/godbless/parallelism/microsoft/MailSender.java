package faang.school.godbless.parallelism.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        Thread thread0 = new Thread(new SenderRunnable(0, 199));
        Thread thread1 = new Thread(new SenderRunnable(200, 399));
        Thread thread2 = new Thread(new SenderRunnable(400, 599));
        Thread thread3 = new Thread(new SenderRunnable(600, 799));
        Thread thread4 = new Thread(new SenderRunnable(800, 999));

        log.info("Starting mail processing.");

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread0.join();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            log.error("During mail processing was thrown an exception.", e);
        }
        log.info("Mail was fully proceed.");
    }
}
