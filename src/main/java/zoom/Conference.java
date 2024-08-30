package zoom;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@Getter
public class Conference {
    private final UUID id;
    private final int awaitingMembersCount;
    private final CyclicBarrier barrier;

    public Conference(int awaitingMembersCount) {
        this.id = UUID.randomUUID();
        this.awaitingMembersCount = awaitingMembersCount;
        barrier = new CyclicBarrier(awaitingMembersCount, this::startStreaming);
    }

    public void startStreaming() {
        log.info("Conference #{} starting", id);
    }
}
