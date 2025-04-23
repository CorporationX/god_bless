package school.faang.put_the_path_with_your_finger;

import lombok.Getter;

@Getter
public class Monster {
    private final String name;
    private final Location location;

    public Monster(String name, Location location) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Не указано имя монстра");
        }
        if (location == null) {
            throw new IllegalArgumentException("Локация должна содержать значение");
        }
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%s находится %s", name, location);
    }
}
