package school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic;

import lombok.Getter;
import school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units.Fighter;

@Getter
public class ThreadFighter extends Thread {
    private Fighter fighter;
    private int result;

    public ThreadFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void run() {
        result = fighter.getPower();
    }

}
