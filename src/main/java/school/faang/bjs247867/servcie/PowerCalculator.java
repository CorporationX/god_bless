package school.faang.bjs247867.servcie;

import lombok.Data;
import lombok.Getter;
import school.faang.bjs247867.model.Character;

@Data
public class PowerCalculator implements Runnable {
    private final Character character;
    private int power;

    @Override
    public void run() {
        this.power = character.getPower();
    }
}
