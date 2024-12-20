package school.faang.bjs_48472;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class MailSender {
    private final int streamsCount;
    private final int mailsCount;
    private final int mailPerThread;

    public MailSender(int streamsCount, int mailsCount, int mailPerThread) {
        this.streamsCount = streamsCount;
        this.mailsCount = mailsCount;
        this.mailPerThread = mailPerThread;
    }

    public int sendMail() {
        ExecutorService executor = Executors.newFixedThreadPool(streamsCount);

        List<SenderRunnable> tasks = IntStream.rangeClosed(0, streamsCount - 1)
                .mapToObj(i -> new SenderRunnable(1 + i * mailPerThread, (i + 1) * mailPerThread))
                .toList();
        tasks.forEach(executor::submit);
        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int sentMails = tasks.stream().mapToInt(SenderRunnable::getCounter).sum();

        if (Objects.equals(sentMails, mailsCount)) {
            log.info("All mails sent");
            return tasks.stream().mapToInt(SenderRunnable::getCounter).sum();
        }

        throw new RuntimeException("Not all Mails sent");
    }
}
