package school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic;

import lombok.Getter;
import lombok.ToString;
import school.faang.Sprints.Multithreading_Parallelism.distributed_army_of_heroes_of_might_and_magic.Units.Fighter;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Army {
    private List<Fighter> fighterList;

    public Army() {
        this.fighterList = new ArrayList<>();
    }

    public void addUnit(Fighter fighter) {
        fighterList.add(fighter);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<ThreadFighter> threadFighters = new ArrayList<>();

        for (Fighter fighter : fighterList) {
            ThreadFighter thread = new ThreadFighter(fighter);
            threadFighters.add(thread);
            thread.start();
        }

        for (ThreadFighter threadFighter : threadFighters) {
            try {
                threadFighter.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += threadFighter.getResult();
        }

        return totalPower;
    }
}
