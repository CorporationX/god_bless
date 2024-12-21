package school.faang.bjs_48472;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
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
        List<SenderRunnable> senderRunnables = IntStream.rangeClosed(0, streamsCount - 1)
                .mapToObj(i -> new SenderRunnable(1 + i * mailPerThread, (i + 1) * mailPerThread))
                .toList();

        List<Thread> threads = senderRunnables.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(thread -> {
            thread.start();
            log.info("Starting thread ");
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        int sum = senderRunnables.stream()
                .mapToInt(SenderRunnable::getCounter)
                .sum();

        if (Objects.equals(sum, mailsCount)) {
            log.info("All mails sent");
            return sum;
        }

        throw new RuntimeException("Not All mails sent");
    }
}
