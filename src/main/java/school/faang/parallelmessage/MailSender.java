package school.faang.parallelmessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int batch = 1000 / 5;
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new SenderRunnable(i * batch, (i + 1) * batch));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток main был прерван.");
            }
        }

        log.info("Все письма отправлены!");
    }
}
