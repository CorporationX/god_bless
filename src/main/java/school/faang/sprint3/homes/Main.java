package school.faang.sprint3.homes;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint3.home.House;
import school.faang.sprint3.home.Officiant;

import java.util.concurrent.*;
@Slf4j
public class Main {

    static final int COUNT_OFFICIANT = 2;
    static final int DELAY = 2;
    static final int FREQUENCY = 10;

    public static void main(String[] args) {
        school.faang.sprint3.home.House house = new House();
        CountDownLatch cdl = new CountDownLatch(house.sizeRoom());
        house.setCdl(cdl);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_OFFICIANT);
        for (int i = 0; i < COUNT_OFFICIANT; i++) {
            executor.scheduleAtFixedRate(new Officiant(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            log.error("Какая т о проблема с потоком : {}", String.valueOf(e));
        }
        executor.shutdown();
        System.out.println("Работа на сегодня закончина");
    }



}
