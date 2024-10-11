package school.faang.heroesmandm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private Integer speed;

    public Integer getDamage() {
        return attack;
    };
}