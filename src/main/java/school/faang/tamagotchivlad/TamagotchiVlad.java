package school.faang.tamagotchivlad;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TamagotchiVlad {
    private String name;
    private String state;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.state = "neutral";
    }

    public synchronized void feed() {
        state = "full";
        System.out.println(name + " is eating. Current state: " + state);
    }

    public synchronized void play() {
        state = "happy";
        System.out.println(name + " is playing. Current state: " + state);
    }

    public synchronized void clean() {
        state = "clean";
        System.out.println(name + " is being cleaned. Current state: " + state);
    }

    public synchronized void sleep() {
        state = "sleeping";
        System.out.println(name + " is sleeping. Current state: " + state);
    }
}
