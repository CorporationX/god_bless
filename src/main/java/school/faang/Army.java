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

    public int calculateTotalPower() {
        ThreadFighter[] threadFighters = new ThreadFighter[fighterList.size()];
        for (Fighter fighter : fighterList) {
                threadFighters(fighter)
        }
    }
}
