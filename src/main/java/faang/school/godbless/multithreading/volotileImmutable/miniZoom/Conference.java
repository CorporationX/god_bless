package faang.school.godbless.multithreading.volotileImmutable.miniZoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private static final int REQUIRED_AMOUNT_PEOPLE = 5;
    private final CyclicBarrier BARRIER = new CyclicBarrier(REQUIRED_AMOUNT_PEOPLE, this::startStreaming);

    private final String name;

    public Conference(String name) {
        this.name = name;
    }

    public void startStreaming() {
        System.out.println("Stream has started!");
    }
}


