package faang.school.godbless.Set_the_Path;

import lombok.Getter;

@Getter
public class Monster {

    private String name;
    private String location;

    public Monster(String name, String location) {
        if (name.isBlank()) throw new IllegalArgumentException("invalid arg(s)");
        else {
            this.name = name;
            this.location = location;
        }
    }
}
