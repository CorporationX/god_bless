package faang.school.godbless.sprint3.armyHeroes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(exclude = "power")
@RequiredArgsConstructor
public abstract class Unit {
    @Setter
    private String name;
    private final int power;
}
