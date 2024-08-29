package superheroes.battle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Superhero {
    private final String name;
    private final int strength;
    private final int agility;
}
