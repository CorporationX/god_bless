package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;

@Data
public class Monster {
    private String name;
    private final Location location;

    public Monster(String name) {
        location = new Location();
        this.name = name;
    }

}
