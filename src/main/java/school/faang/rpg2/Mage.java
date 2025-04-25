package school.faang.rpg2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mage implements Fighter {
    private final int power;

    @Override
    public int getPower() { return power; }
}
