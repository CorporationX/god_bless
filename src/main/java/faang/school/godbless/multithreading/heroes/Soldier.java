package faang.school.godbless.multithreading.heroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Soldier {

    private final int power;

    public abstract SoldierType getType();
}
