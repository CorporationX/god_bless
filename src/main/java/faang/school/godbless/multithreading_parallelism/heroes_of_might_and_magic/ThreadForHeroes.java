package faang.school.godbless.multithreading_parallelism.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadForHeroes extends Thread{

    private final Character unit;
    private int power;

    public ThreadForHeroes(Character unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}
