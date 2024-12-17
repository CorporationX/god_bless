package school.faang.task_47726;

import lombok.Getter;

@Getter
public class Calculate extends Thread {
    private final Fighter fighter;
    private int power;
    Thread thread;

    public Calculate(Fighter fighter, int power) {
        this.power = power;
        this.fighter = fighter;
        thread = new Thread(this, fighter.getClass().getName());
        System.out.println(String.format("New thread: %s", thread));
    }

    public int getPower() {
        return fighter.getPower();
    }

}
