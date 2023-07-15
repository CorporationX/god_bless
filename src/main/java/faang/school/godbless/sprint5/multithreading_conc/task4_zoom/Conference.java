package faang.school.godbless.sprint5.multithreading_conc.task4_zoom;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.CyclicBarrier;

@Getter
@NoArgsConstructor
public class Conference {

    private final int numOfSpeakers = 5;

    private final CyclicBarrier barrier = new CyclicBarrier(numOfSpeakers, this::startStreaming);

    public void startStreaming() {
        System.out.println("Трансляция началась");
    }
}
