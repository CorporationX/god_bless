package faang.school.godbless.mini_zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(){
        try {
            int connectionTime = ThreadLocalRandom.current().nextInt(1000, 4000);

            Thread.sleep(connectionTime);
            log.info(name + "JOINED conversation");

            Conference.BARRIER.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Conference was interrupted during waiting: " + e.getMessage());
        } catch (BrokenBarrierException e) {
            throw new RuntimeException("Barrier was broken: " + e.getMessage());
        }

        Conference.startStreaming(name);
    }
}
