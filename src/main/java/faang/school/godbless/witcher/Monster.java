package faang.school.godbless.witcher;

import lombok.Data;

@Data
public class Monster {
    private String name;
    private City city;
    private int killTime;

    public Monster(String name, City city, int killTime) {
        this.name = name;
        this.city = city;
        this.killTime = killTime;
    }
}
