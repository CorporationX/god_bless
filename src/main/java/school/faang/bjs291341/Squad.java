package school.faang.bjs291341;

import lombok.Getter;
import school.faang.bjs291341.warrior.Archer;
import school.faang.bjs291341.warrior.Mage;
import school.faang.bjs291341.warrior.Swordsman;
import school.faang.bjs291341.warrior.Unit;

import java.util.List;

@Getter
public class Squad implements Runnable {
    private int totalPower;
    private final List<Unit> warriors;

    public Squad(String descriptionSquad, List<Unit> warriors) {
        this.warriors = warriors;
        this.totalPower = 0;
    }

    @Override
    public void run() {
        calculateSquadPower();
    }

    public void calculateSquadPower() {
        for (Unit unit : warriors) {
            this.totalPower += unit.getPower();
        }
    }
}
