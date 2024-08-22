package faang.school.godbless.microsoft.outlook;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MainSender {
    private static final int[] RANGE_1 = {0, 200};
    private static final int[] RANGE_2 = {200, 400};
    private static final int[] RANGE_3 = {400, 600};
    private static final int[] RANGE_4 = {600, 800};
    private static final int[] RANGE_5 = {800, 1000};

    public static void main(String[] args) {

        List<Thread> threads = List.of(
                new Thread(new SenderRunnable(RANGE_1[0], RANGE_1[1])),
                new Thread(new SenderRunnable(RANGE_2[0], RANGE_2[1])),
                new Thread(new SenderRunnable(RANGE_3[0], RANGE_3[1])),
                new Thread(new SenderRunnable(RANGE_4[0], RANGE_4[1])),
                new Thread(new SenderRunnable(RANGE_5[0], RANGE_5[1])));

        threads.forEach(Thread::start);

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("All messages have just sent");
        } catch (InterruptedException exception) {
            log.error("An error occurred while sending the emails", exception);
        }
    }
}
