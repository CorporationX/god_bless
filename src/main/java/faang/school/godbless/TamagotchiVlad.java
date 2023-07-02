package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class TamagotchiVlad {
    private String name;
    private boolean isHungry;
    private boolean isDirty;
    private boolean isSleeping;

    public TamagotchiVlad(String name) {
        this.name = name;
        this.isHungry = false;
        this.isDirty = false;
        this.isSleeping = false;
    }

    public synchronized void feed() {
        isHungry = false;
        System.out.println(name + " has been fed.");
    }

    public synchronized void play() {
        System.out.println(name + " is playing.");
    }

    public synchronized void clean() {
        isDirty = false;
        System.out.println(name + " has been cleaned.");
    }

    public synchronized void sleep() {
        isSleeping = true;
        System.out.println(name + " is sleeping.");
    }

    public synchronized void wakeUp() {
        isSleeping = false;
        System.out.println(name + " woke up.");
    }

    public synchronized void setHungry() {
        isHungry = true;
        System.out.println(name + " is hungry.");
    }

    public synchronized void setDirty() {
        isDirty = true;
        System.out.println(name + " is dirty.");
    }
}
