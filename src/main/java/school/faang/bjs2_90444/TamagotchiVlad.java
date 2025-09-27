package school.faang.bjs2_90444;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;
    private String state = "обычное";

    public synchronized void feed() {
        state = "сыт";
        System.out.println(name + " ест. Его состояние: " + state);
    }

    public synchronized void play() {
        state = "весел";
        System.out.println(name + " играет. Его состояние: " + state);
    }

    public synchronized void clean() {
        state = "чист";
        System.out.println(name + " чистится. Его состояние: " + state);
    }

    public synchronized void sleep() {
        state = "спит";
        System.out.println(name + " спит. Его состояние: " + state);
    }
}
