package school.faang.multithreading.parallelism.bjs2_91330;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Warrior> {

    private String warriorsName;
    private List<T> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(warrior -> warrior.power)
                .sum();
    }
}