package school.faang.BJS2_36396_NormalGamePigs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Thread[] pigThreads = {
                new Pig1Thread(),
                new Pig2Thread(),
                new Pig3Thread()
        };

        Arrays.stream(pigThreads).forEach(Thread::start);
        Arrays.stream(pigThreads).forEach(pigThread -> {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                log.error("Main thread was interrupted while waiting for {} to finish!", pigThread.getName(), e);
            }
        });

        log.info("All pigs built their houses!");
    }
}
