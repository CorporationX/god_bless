package school.faang.magic;

import java.util.List;

class Squad {
    private final String name;
    private final List<?> fighters;

    public Squad(String name, List<?> fighters) {
        this.name = name;
        this.fighters = fighters;
    }

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(fighter -> {
                    if (fighter instanceof Arher) {
                        return ((Arher) fighter).getPower();
                    } else if (fighter instanceof Swordsman) {
                        return ((Swordsman) fighter).getPower();
                    } else if (fighter instanceof Mage) {
                        return ((Mage) fighter).getPower();
                    }
                    return 0;
                })
                .sum();
    }

    private String getName() {
        return name;
    }
}