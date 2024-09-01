package faang.school.godbless.BJS2_25670;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
@RequiredArgsConstructor
public class Participant {
    private static final int AWAIT_TIME = 5;
    private final String name;

    public void joinConference(Conference conference) {
        System.out.println("Participant " + name + " joined conference " + conference.getName());

        try {
            conference.getBarrier().await(AWAIT_TIME, TimeUnit.MINUTES);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
