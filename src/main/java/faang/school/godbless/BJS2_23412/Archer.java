package faang.school.godbless.BJS2_23412;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Archer implements Unit {

    private final int power;

    @Override
    public int getPower() {
        return power;
    }
}
