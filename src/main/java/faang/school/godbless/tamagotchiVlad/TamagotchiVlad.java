package faang.school.godbless.tamagotchiVlad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TamagotchiVlad {

    private String name;

    private boolean isHungry;

    private boolean isDirty;

    private boolean isSleeping;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.isHungry = true;
        this.isDirty = true;
        this.isSleeping = false;
    }

    public synchronized void feed() {
        if (isHungry) {
            System.out.println(name + " is being fed.");
            isHungry = false;
        } else {
            System.out.println(name + " is not hungry.");
        }
    }

    public synchronized void play() {
        System.out.println(name + " is playing.");
    }

    public synchronized void clean() {
        if (isDirty) {
            System.out.println(name + " is being cleaned.");
            isDirty = false;
        } else {
            System.out.println(name + " is already clean.");
        }
    }

    public synchronized void sleep() {
        if (!isSleeping) {
            System.out.println(name + " is going to sleep.");
            isSleeping = true;
        } else {
            System.out.println(name + " is already sleeping.");
        }
    }
}
