package school.faang.bjs2_91288;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad<T extends Unit> {
    private String name;
    private List<T> squad;

    public int calculateSquadPower() {
        int totalPower = 0;
        for (T person : squad) {
            totalPower += person.getPower();
        }
        return totalPower;
    }
}
