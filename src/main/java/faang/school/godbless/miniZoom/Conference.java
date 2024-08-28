package faang.school.godbless.miniZoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private static final int PARTICIPANTS_TO_START = 5;

    private final String name;
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTICIPANTS_TO_START, this::startStreaming);

    public Conference(String name) {
        this.name = name;
    }

    public void startStreaming() {
        System.out.println("Conference started!");
    }
}
