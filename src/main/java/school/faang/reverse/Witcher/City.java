package school.faang.reverse.Witcher;

import lombok.Getter;

@Getter
class City {
    private final String name;
    private final Location location;

    public City(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}