package school.faang.multithreading.parallelism.bjs2_72877.microsoft_working;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MailSender {
    private static final int THREAD_COUNT = 5;
    public static final int LETTER_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread [] threadsArray = new Thread[THREAD_COUNT];
        int startIndex = 1;
        int batchCount = LETTER_COUNT / THREAD_COUNT;
        int endIndex = batchCount;

        for (int i = 0; i < THREAD_COUNT; i++) {
            threadsArray[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            startIndex += batchCount;
            endIndex += batchCount;
        }

        Arrays.stream(threadsArray).forEach(Thread::start);

        for (Thread thread : threadsArray) {
            thread.join();
        }

        log.info("all letters are sent");
    }
}
