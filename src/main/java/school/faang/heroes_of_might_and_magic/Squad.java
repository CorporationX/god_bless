package school.faang.heroes_of_might_and_magic;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class Squad<T> {
    List<T> fighters;

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(fighter -> {
                    if (fighter instanceof Archer) {
                        return ((Archer) fighter).getPower();
                    } else if (fighter instanceof Swordsman) {
                        return ((Swordsman) fighter).getPower();
                    } else if (fighter instanceof Mage) {
                        return ((Mage) fighter).getPower();
                    }
                    return 0;
                })
                .sum();
    }
}