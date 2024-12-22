package school.faang.bjs49802;

import lombok.ToString;

@ToString(of = "name")
public class TamagotchiVlad {

    private String name;
    private String state = "fine";

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        state = "full";
        System.out.printf("%s is being fed. His state is %s\n", name, state);
    }

    public synchronized void play() {
        state = "cheerful";
        System.out.printf("%s is playing. His state is %s\n", name, state);
    }

    public synchronized void clean() {
        state = "clean";
        System.out.printf("%s is being cleaned. His state is %s\n", name, state);
    }

    public synchronized void sleep() {
        state = "dizzy";
        System.out.printf("%s is sleeping. His state is %s\n", name, state);
    }

}
