package faang.school.godbless.thirdSprint.Tamagotchi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TamagotchiVlad {
    private final int vladId;
    private boolean isHungry;
    private boolean isBored;
    private boolean isDirty;
    private boolean isSleepy;

    public TamagotchiVlad(int vladId) {
        this.vladId = vladId;
        isHungry = true;
        isBored = true;
        isDirty = true;
        isSleepy = true;
    }

    public synchronized void feed() {
        System.out.println("Vlad №" + vladId + " is not hungry now");
        isHungry = false;
    }

    public synchronized void play() {
        System.out.println("You played with vlad №" + vladId + ". He is very happy now.");
        isBored = false;
    }

    public synchronized void clean() {
        System.out.println("You cleaned vlad №" + vladId + ". Now he doesn't smell like a garbage.");
        isDirty = false;
    }

    public synchronized void sleep() {
        System.out.println("Vlad №" + vladId + " slept well and now ready for every task.");
        isSleepy = false;
    }

    public synchronized void printVladState() {
        System.out.println("Vlad №" + vladId + " hungry: " + isHungry);
        System.out.println("Vlad №" + vladId + " bored: " + isBored);
        System.out.println("Vlad №" + vladId + " dirty: " + isDirty);
        System.out.println("Vlad №" + vladId + " sleepy: " + isSleepy);
    }
}
