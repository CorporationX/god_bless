package school.faang.task61254.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad<T> {
    private String name;
    private List<T> warriors;

    public int calculateSquadPower() {
        return warriors.stream()
                .mapToInt(warrior -> {
                    if (warrior instanceof Archer) {
                        return ((Archer) warrior).getPower();
                    } else if (warrior instanceof Swordsman) {
                        return ((Swordsman) warrior).getPower();
                    } else if (warrior instanceof Mage) {
                        return ((Mage) warrior).getPower();
                    }
                    return 0;
                })
                .sum();
    }
}