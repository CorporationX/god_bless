package school.faang.bjs2_91457;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Fighter {
    private final int power;

    int getPower() {
        return power;
    }
}
