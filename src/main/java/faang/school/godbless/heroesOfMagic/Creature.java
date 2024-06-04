package faang.school.godbless.heroesOfMagic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {

    private String name;
    private Integer level;
    private Integer attack;
    private Integer defence;
    private Integer speed;
    private Integer quantity;

    public Integer getDamage() {
        return attack * quantity;
    }

    public abstract Creature createInstance(Integer quantity);
}
