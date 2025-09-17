package school.faang.bjs2_91500;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CalculatePower extends Thread {
    private List<Squad> unitList = new ArrayList<>();
    @Getter
    private int power;

    public CalculatePower(Squad squad) {
        if (squad == null) {
            log.info("Squad don't be null" + getClass());
            throw new IllegalArgumentException("Группа не может быть пустая");
        }
        unitList.add(squad);
    }

    @Override
    public void run() {
        this.power = unitList.stream()
                .mapToInt(Squad::calculateSquadPower).sum();
    }
}
