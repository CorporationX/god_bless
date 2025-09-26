package school.faang.heroies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Army {
    private List<Squad> squads = new ArrayList<>();
    private int totalPower;

    public int calculateTotalPower() {
        squads.forEach(squad -> totalPower += squad.getTotalSquadPower());
        return totalPower;
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
