package school.faang.put_the_path_with_your_finger;

import lombok.Getter;

@Getter
public final class City {
    private final String name;
    private final Location location;

    public City(String name, Location location) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Не указано название города");
        }
        if (location == null) {
            throw new IllegalArgumentException("Локация должна содержать значение");
        }
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("Город %s %s", name, location);
    }

}
