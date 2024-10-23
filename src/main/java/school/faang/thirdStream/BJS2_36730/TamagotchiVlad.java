package school.faang.thirdStream.BJS2_36730;

import lombok.Getter;

@Getter
public class TamagotchiVlad {
    private final String name;
    private State state;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.state = State.NEUTRAL;
    }

    public synchronized void feed() {
        System.out.printf("%s ест ", this.name);
        this.state = State.FULL;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void play() {
        System.out.printf("%s играет ", this.name);
        this.state = State.CHEERFUL;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void clean() {
        System.out.printf("%s нехотя убирается ", this.name);
        this.state = State.CLEANSED_KARMA;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void sleep() {
        System.out.printf("%s спит ", this.name);
        this.state = State.FULL_OF_ENERGY;
        System.out.printf("его состояние %s%n", this.state);
    }
}
