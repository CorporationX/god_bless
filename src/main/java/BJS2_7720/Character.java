package BJS2_7720;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Character {
    private final String name;
    protected final int power;
    protected final  int dexterity;
    protected final int intelligence;
    protected int health = 100;

    public abstract void attack(Character character);
}
