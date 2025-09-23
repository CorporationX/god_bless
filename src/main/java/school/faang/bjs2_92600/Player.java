package school.faang.bjs2_92600;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    private int level = 1;
    @Setter private int experience = 0;

    public Player(String name) {
        this.name = name;
    }
}
