package school.faang.task_47623.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Archer extends Character {
    private final int power;

    @Override
    public int getPower() {
        return power;
    }
}
