package school.faang.reverse.Witcher;

import lombok.Getter;

@Getter
class Monster {
    private final String name;
    private final Location location;

    public Monster(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
