package faang.school.godbless.base_priem;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private final static long TIME_LIMIT_IN_MILLIS = 10000L;
    private final static long MESSAGE_CHANGING_IN_MILLIS = 5000L;
    private final static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        MilitaryBase firstMilitaryBase = new MilitaryBase("FirstMilitaryBase");
        MilitaryBase secondMilitaryBase = new MilitaryBase("SecondMilitaryBase");

        LinkedBlockingQueue<byte[]> firstBaseInbox = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<byte[]> secondBaseInbox = new LinkedBlockingQueue<>();

        firstMilitaryBase.setOPPONENT_INBOX(secondBaseInbox);
        secondMilitaryBase.setOPPONENT_INBOX(firstBaseInbox);

        executorService.submit(firstMilitaryBase);
        executorService.submit(secondMilitaryBase);

        try {
            Thread.sleep(MESSAGE_CHANGING_IN_MILLIS);
            firstMilitaryBase.stop();
            secondMilitaryBase.stop();
            executorService.shutdown();
            boolean isFinished = executorService.awaitTermination(TIME_LIMIT_IN_MILLIS, TimeUnit.SECONDS);
            if (isFinished) {
                log.info("Message exchanging was finished on time");
            }
        } catch (InterruptedException e) {
            log.error("Message exchanging was interrupted", e);
            throw new RuntimeException(e);
        }
    }
}
