package school.faang.works_holds;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;

@Getter
public class MultiThreadCounter {
    public static final CountDownLatch countDownLatch = new CountDownLatch(Main.THREAD_COUNT);
}
