package school.faang.bjs2_90000;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String soldierTypeName;
    private List<Soldier> squadMembers;

    public int calculateTotalPower() {
        return squadMembers.stream().mapToInt(Soldier::getPower).sum();
    }
}
