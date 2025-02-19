package bjs260443;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class MailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);
    private static final Long LETTER_NUMBERS = 1000L;
    private static final Long THREAD_NUMBERS = 5L;

    public static void main(String[] args) {
        List<SenderRunnable> senderRunnables = new ArrayList<>();
        List<Long> numbers = LongStream.range(0, LETTER_NUMBERS).sorted().boxed().toList();
        long startIndex;
        long endIndex;
        long lettersInEachThreadNumbers = 0;
        if (THREAD_NUMBERS != 0) {
            lettersInEachThreadNumbers = LETTER_NUMBERS / THREAD_NUMBERS;
        }
        for (long i = 0; i < numbers.size(); i += lettersInEachThreadNumbers) {
            Long zeroElement = numbers.get((int) i);
            if (zeroElement == 0) {
                startIndex = zeroElement;
                endIndex = lettersInEachThreadNumbers - 1;
                senderRunnables.add(new SenderRunnable(startIndex, endIndex));
                continue;
            }
            startIndex = i;
            endIndex = i + lettersInEachThreadNumbers - 1;
            senderRunnables.add(new SenderRunnable(startIndex, endIndex));
        }
        List<Thread> threads = getThreads(senderRunnables);
        threads.forEach(Thread::start);
        threads.forEach(startedThread -> {
            try {
                startedThread.join();
            } catch (InterruptedException e) {
                LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                        startedThread.getName());
                throw new RuntimeException(e);
            }
        });
        System.out.println("All threads have finished");
    }

    private static List<Thread> getThreads(List<SenderRunnable> senderRunnables) {
        List<Thread> threads = new ArrayList<>();
        senderRunnables.forEach(senderRunnable -> {
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
        });
        return threads;
    }
}
