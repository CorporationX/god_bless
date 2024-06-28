package faang.school.godbless.mini_zoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    public static final int NUMBER_OF_PARTICIPANTS = 10;
    public static final CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_PARTICIPANTS);

    public static void startStreaming(String participantName) {
        log.info(participantName + " started streaming");
    }
}
