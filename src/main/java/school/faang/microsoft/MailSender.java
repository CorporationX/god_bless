package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 16.06.2025
 */
@Slf4j
public class MailSender {

    public static void main(String[] args) {
        try {
            var sender1 = new Thread(new SenderRunnable(1, 200), "Sender1");
            sender1.start();
            sender1.join();

            var sender2 = new Thread(new SenderRunnable(201, 400), "Sender2");
            sender2.start();
            sender2.join();

            var sender3 = new Thread(new SenderRunnable(401, 600), "Sender3");
            sender3.start();
            sender3.join();

            var sender4 = new Thread(new SenderRunnable(601, 800), "Sender4");
            sender4.start();
            sender4.join();

            var sender5 = new Thread(new SenderRunnable(801, 1000), "Sender5");
            sender5.start();
            sender5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Основной поток | Произошло прерывание: {}", e.getMessage());
        }
    }
}
