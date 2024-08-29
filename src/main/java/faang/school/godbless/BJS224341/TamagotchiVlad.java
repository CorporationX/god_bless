package faang.school.godbless.BJS224341;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TamagotchiVlad {
    private String name;
    private boolean isHungry = true;
    private boolean isDirty = true;
    private boolean isTired = true;
    private boolean isHappy = false;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        if (isHungry) {
            System.out.println(name + " is eating");
            isHungry = false;
            isHappy = true;
        } else {
            System.out.println(name + " is not hungry");
        }
    }

    public synchronized void play() {
        if (isHappy) {
            System.out.println(name + " is playing");
            isHappy = false;
            isTired = true;
        } else {
            System.out.println(name + " is don't want to play");
        }
    }

    public synchronized void clean() {
        if (isDirty) {
            System.out.println(name + " is cleaning");
            isDirty = false;
        } else {
            System.out.println(name + " is already clean");
        }
    }

    public synchronized void sleep() {
        if (isTired) {
            System.out.println(name + " is sleeping");
            isTired = false;
            isHungry = true;
        } else {
            System.out.println(name + " is not tired");
        }
    }
}
