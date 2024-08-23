package faang.school.godbless.BJS2_24450;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagotchiVlad {
    private int id;

    public synchronized void feed() {
        System.out.printf("Влад%d кушает%n", id);
        waitProcess(3000L);
        System.out.printf("Влад%d покушал%n", id);
    }

    public synchronized void play() {
        System.out.printf("Влад%d играет%n", id);
        waitProcess(4000L);
        System.out.printf("Влад%d поиграл%n", id);
    }

    public synchronized void clean() {
        System.out.printf("Влад%d убирает свою комнату%n", id);
        waitProcess(4000L);
        System.out.printf("Влад%d убрал свою комнату%n", id);
    }

    public synchronized void sleep() {
        System.out.printf("Влад%d лег спать%n", id);
        waitProcess(8000L);
        System.out.printf("Влад%d проснулся%n", id);
    }

    private static void waitProcess(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
