package school.faang.microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        MailConfig mailConfig = new MailConfig();

        List<Thread> threadList = IntStream.range(0, mailConfig.getThreadCount())
                .mapToObj(threadIndex -> {
                    int start = threadIndex * mailConfig.getBatchSize();
                    int end = (threadIndex + 1) * mailConfig.getBatchSize();
                    return new Thread(new SenderRunnable(start, end), "Thread-" + (threadIndex + 1));
                })
                .toList();
        threadList.forEach(Thread::start);

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted", e);
                Thread.currentThread().interrupt();
            }
        }
        log.info("All messages have been sent.");
    }
}