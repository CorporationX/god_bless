package faang.school.godbless.character;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor()
public abstract class Character {

    @NonNull
    private String name;
    private Integer power;
    private Integer agility;
    private Integer intelligence;
    private Integer health = 100;

    public Character(@NonNull String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}


