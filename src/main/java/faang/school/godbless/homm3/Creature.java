package faang.school.godbless.homm3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int speed;
    private int damage;
    private int defense;
    private int quantity;
}
