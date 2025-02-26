package school.faang.BJS2_61322;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Squad {
    private ArrayList<Unity> unities = new ArrayList<>();

    public int calculateSquadPower() {
        return unities.stream()
                .mapToInt(Unity::getPower)
                .sum();
    }

    public void addUnit(Unity unity) {
        unities.add(unity);
    }
}
