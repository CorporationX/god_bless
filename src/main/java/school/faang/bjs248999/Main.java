package school.faang.bjs248999;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int COUNT_OFFICIANT = 2;
    public static final int DELAY = 0;
    public static final int NUMBER_ROOMS = 9;
    public static final int AMOUNT_FOOD = 2;
    public static final int TIMEOUT_WORK_FINISH = 5;
    public static int FREQUENCY = 2;

    public static void main(String[] args) {

        House house = new House(NUMBER_ROOMS, AMOUNT_FOOD);
        CountDownLatch countDownLatch = new CountDownLatch(house.numberRooms());
        house.setCountDownLatch(countDownLatch);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_OFFICIANT);
        for (int i = 0; i < COUNT_OFFICIANT; i++) {
            executor.scheduleAtFixedRate(new Officiant(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            log.error("Error count down latch await! {}", String.valueOf(ex));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_WORK_FINISH, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Еда в доме собрана!");
    }
}
