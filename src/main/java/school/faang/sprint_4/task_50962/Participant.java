package school.faang.sprint_4.task_50962;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
@RequiredArgsConstructor
@ToString
public class Participant {
    private final int id;

    public void joinConference(Conference conference) {
        CountDownLatch countDownLatch = conference.getCountDownLatch();
        countDownLatch.countDown();
        log.info("Participant {} join {}.", this, conference);
    }
}
