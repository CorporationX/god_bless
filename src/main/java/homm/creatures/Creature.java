package homm.creatures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract public class Creature {
    @NonNull
    private String name;
    private int level;
    private int damage;
    private int defense;
    private int speed;
    private int count;
    private int health;
}
