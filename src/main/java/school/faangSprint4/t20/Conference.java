package school.faangSprint4.t20;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    private void startStreaming() {
        System.out.println("\nВсе участники присоединились! Начинаем трансляцию!\n");
    }
}