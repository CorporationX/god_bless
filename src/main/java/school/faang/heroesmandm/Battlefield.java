package school.faang.heroesmandm;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Battlefield {
    private Hero first;
    private Hero second;

    public Hero battle() {
        return armyPower(first.getArmy()) >= armyPower(second.getArmy()) ? first : second;
    }

    private Integer armyPower(Map<Creature, Integer> army) {
        return army.entrySet().stream()
                .map(entry -> entry.getKey().getDamage() * entry.getValue())
                .reduce(0, (integer, integer2) -> integer + integer2);
    }
}