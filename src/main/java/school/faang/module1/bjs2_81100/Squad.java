package school.faang.module1.bjs2_81100;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad <T extends Warrior> {

    private final String name;
    private final List<T> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}