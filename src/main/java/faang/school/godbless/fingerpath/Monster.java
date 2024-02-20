package faang.school.godbless.fingerpath;

public class Monster {
    private final String name;
    private final Location location;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

    public Monster(String name, Location location) {
        this.name = name;
        this.location = location;

    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
