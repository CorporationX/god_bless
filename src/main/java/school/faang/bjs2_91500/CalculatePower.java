package school.faang.bjs2_91500;

import lombok.Getter;
import java.util.List;

public class CalculatePower extends Thread {
    private List<Squad> unitList;
    @Getter
    private int power;

    public CalculatePower(List<Squad> squad) {
        this.unitList = squad;
    }

    @Override
    public void run() {
        this.power = unitList.stream()
                .mapToInt(Squad::calculateSquadPower).sum();
    }
}
