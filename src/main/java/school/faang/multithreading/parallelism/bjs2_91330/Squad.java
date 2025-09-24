package school.faang.multithreading.parallelism.bjs2_91330;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String warriorsName;
    private List<Warrior> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}