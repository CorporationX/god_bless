package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    String name;
    int level;
    int ataka;
    int defence;
    int velocity;
    int quantity;

    int getDemage() {
        return ataka * quantity;
    }

}
