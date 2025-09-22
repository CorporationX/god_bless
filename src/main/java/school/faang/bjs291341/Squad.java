package school.faang.bjs291341;

import lombok.Getter;
import school.faang.bjs291341.warrior.Archer;
import school.faang.bjs291341.warrior.Mage;
import school.faang.bjs291341.warrior.Swordsman;

import java.util.List;

@Getter
public class Squad implements Runnable {
    private int totalPower;
    private final List<?> warriors;

    public Squad(String descriptionSquad, List<?> warriors) {
        this.warriors = warriors;
        this.totalPower = 0;
    }

    @Override
    public void run() {
        calculateSquadPower();
    }

    public void calculateSquadPower() {
        for (Object e : warriors) {
            if (e instanceof Archer) {
                this.totalPower += ((Archer) e).getPower();
            } else if (e instanceof Swordsman) {
                this.totalPower += ((Swordsman) e).getPower();
            } else if (e instanceof Mage) {
                this.totalPower += ((Mage) e).getPower();
            }
        }
    }
}
