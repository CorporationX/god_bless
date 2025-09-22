package school.faang.bjs291341.warrior;

import lombok.Getter;

@Getter
public class Mage {
    private Integer power;
    private static final String description = "Маги";

    public Mage(int i) {
        this.power = i;
    }
}
