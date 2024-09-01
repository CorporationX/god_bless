package faang.school.godbless.BJS2_25670;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CyclicBarrier;

@Getter
@RequiredArgsConstructor
public class Conference {
    private final String name;
    private static final int PARTICIPATION_COUNT = 20;
    private final CyclicBarrier barrier = new CyclicBarrier(PARTICIPATION_COUNT, this::startStreaming);

    public void startStreaming() {
        System.out.println("Starting streaming...");
    }
}
