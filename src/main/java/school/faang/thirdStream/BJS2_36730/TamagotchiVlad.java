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
        this.state = State.Full;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void play() {
        System.out.printf("%s играет ", this.name);
        this.state = State.Cheerful;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void clean() {
        System.out.printf("%s нехотя убирается ", this.name);
        this.state = State.Cleansed_Karma;
        System.out.printf("его состояние %s%n", this.state);
    }

    public synchronized void sleep() {
        System.out.printf("%s спит ", this.name);
        this.state = State.Full_Of_Energy;
        System.out.printf("его состояние %s%n", this.state);
    }
}
