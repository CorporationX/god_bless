package faang.school.godbless.MiniZoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private String name;
    private int NUMBER_OF_PARTICIPANTS = 5;
    private CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_PARTICIPANTS);

    public Conference(String name) {
        this.name = name;
    }

    public void startStreaming() {
        System.out.println("Трансляция началась");
    }
}
