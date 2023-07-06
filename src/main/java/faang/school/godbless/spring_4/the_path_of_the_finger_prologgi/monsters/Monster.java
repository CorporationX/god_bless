package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.monsters;

public class Monster {
    private final String name;
    private final String location;

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
