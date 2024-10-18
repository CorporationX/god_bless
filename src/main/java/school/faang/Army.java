package school.faang;

import lombok.Getter;
import lombok.ToString;
import school.faang.Fighter.Fighter;

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

    public int calculateTotalPower() throws InterruptedException{
        int totalPower = 0;
        List<ThreadFighter> threadFighters = new ArrayList<>();

        for (Fighter fighter : fighterList) {
            ThreadFighter thread = new ThreadFighter(fighter);
            threadFighters.add(thread);
            thread.start();
        }

        for (ThreadFighter threadFighter : threadFighters) {
                threadFighter.join();
                totalPower += threadFighter.getResult();
        }

        return totalPower;
    }
}
