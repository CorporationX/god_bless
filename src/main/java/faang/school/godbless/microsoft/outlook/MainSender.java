package faang.school.godbless.microsoft.outlook;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
public class MainSender {
    private static final Logger logger = LoggerFactory.getLogger(MainSender.class);

    public static void main(String[] args) {

        List<Thread> threads = List.of(
                new Thread(new SenderRunnable(0, 200)),
                new Thread(new SenderRunnable(200, 400)),
                new Thread(new SenderRunnable(400, 600)),
                new Thread(new SenderRunnable(600, 800)),
                new Thread(new SenderRunnable(800, 1000)));

        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("All messages have just sent");
        } catch (InterruptedException exception) {
            logger.error("An error occurred while sending the emails", exception);
        }
    }
}
