package school.faang.task_BJS2_61262;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mage implements Fighter {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
