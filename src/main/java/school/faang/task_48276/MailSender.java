package school.faang.task_48276;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int startIndex = 0;
        int endIndex = 199;
        int threadAmount = 5;
        List<Thread> threadList = new ArrayList<>(threadAmount);

        for (int i = 0; i < threadAmount; i++) {
            threadList.add(new Thread(
                    new SenderRunnable(startIndex, endIndex))
            );
            startIndex = endIndex + 1;
            endIndex += 200;
        }

        threadList.forEach(Thread::start);
        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Error occurred: {}", e.getMessage());
        }
        log.info("All emails have been sent");
    }
}
