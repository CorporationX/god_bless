package school.faang.magic;

import lombok.Getter;

import java.util.List;

class Squad {
    @Getter(lombok.AccessLevel.PRIVATE)
    private final String name;

    @Getter
    private final List<? extends Warriors> fighters;

    public Squad(String name, List<? extends Warriors> fighters) {
        this.name = name;
        this.fighters = fighters;
    }

    public int calculateSquadPower() {
        return fighters.stream()
                .mapToInt(Warriors::getPower)
                .sum();
    }
}