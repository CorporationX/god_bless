package school.faang.task_BJS2_61262;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Swordsman implements Fighter {
    private int power;

    @Override
    public int getPower() {
        return power;
    }
}
