package faang.school.godbless.data;

import lombok.Getter;

@Getter
public class Monster {
    private String name;
    private String location;

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
