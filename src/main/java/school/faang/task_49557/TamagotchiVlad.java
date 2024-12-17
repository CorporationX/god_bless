package school.faang.task_49557;

public class TamagotchiVlad {
    private VladState state;

    public synchronized void feed() {
        state = VladState.FEEDING;
        printCurrentState();
    }

    public synchronized void play() {
        state = VladState.PLAYING;
        printCurrentState();
    }

    public synchronized void clean() {
        state = VladState.CLEANING;
        printCurrentState();
    }

    public synchronized void sleep() {
        state = VladState.SLEEPING;
        printCurrentState();
    }

    public void printCurrentState() {
        System.out.println("Владик сейчас: " + state);
    }
}