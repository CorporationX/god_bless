package faang.school.godbless.minizoom;

import java.util.concurrent.CyclicBarrier;

public class Conference {

    private static final int REQUIRED_PARTICIPANTS = 10;
    private final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(REQUIRED_PARTICIPANTS, this::startStreaming);

    public CyclicBarrier getCyclicBarrier() {
        return CYCLIC_BARRIER;
    }

    private void startStreaming() {
        System.out.println("Stream started");
    }
}
