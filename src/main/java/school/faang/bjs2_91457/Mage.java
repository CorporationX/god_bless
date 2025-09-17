package school.faang.bjs2_91457;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Mage implements Fighter {
    private final int power;

    @Override
    public int getPower() {
        return power;
    }
}
