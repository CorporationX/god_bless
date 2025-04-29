package school.faang.BJS2_72305;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Squad {
    String name;
    List<Unit> squadMembers = new ArrayList<>();

    public void addUnit(Unit unit) {
        squadMembers.add(unit);
    }

    public int calculateSquadPower() {
        return squadMembers.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }


}
