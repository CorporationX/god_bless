package school.faang.bjs2_81036_thread_heroes;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Soldier> {
    private final String squadName;
    private final List<T> soldiers;

    public int calculateSquadPower() {
        return soldiers.stream()
                .mapToInt(Soldier::getPower)
                .sum();
    }
}
