package school.faang.sprint_3.task_48492;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        Thread[] sentMail = new Thread[5];

        for (int i = 0; i < sentMail.length; i++) {
            sentMail[i] = new Thread(new SenderRunnable(200 * i, (i + 1) * 200));
            sentMail[i].start();
        }

        for (Thread sendJoin : sentMail) {
            try {
                sendJoin.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread over with exception{}", e.getMessage());
            }
        }

        System.out.println("Письма успешно отправлены");
    }
}
