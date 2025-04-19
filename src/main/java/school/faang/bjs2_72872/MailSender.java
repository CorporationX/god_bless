package school.faang.bjs2_72872;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = List.of(
                new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(201, 400)),
                new Thread(new SenderRunnable(401, 600)),
                new Thread(new SenderRunnable(601, 800)),
                new Thread(new SenderRunnable(801, 1000)));

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                log.error(ex.getMessage());
            }
        });
        log.info("All letters have been sent");
    }
}
