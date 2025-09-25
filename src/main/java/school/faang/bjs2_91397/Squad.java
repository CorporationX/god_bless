package school.faang.bjs2_91397;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Squad<T extends Fighter> {
    private final String name;
    private final List<T> fighters = new ArrayList<>();

    public Squad(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть нулевым или незаполненным");
        }
        this.name = name;
    }

    public void addFighter(T fighter) {
        if (fighter == null) {
            throw new IllegalArgumentException("Не может быть null");
        }
        fighters.add(fighter);
    }

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Fighter::getPower)
                .sum();
    }
}
