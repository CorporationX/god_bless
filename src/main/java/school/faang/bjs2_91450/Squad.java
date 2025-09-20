package school.faang.bjs2_91450;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Character> {
    private List<T> squad;

    public int calculateSquadPower() {
        return squad.stream()
                .mapToInt(T::getPower)
                .sum();
    }
}
