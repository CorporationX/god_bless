package faang.school.godbless.BJS2_2524;

import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
public abstract class Character {
    @NonNull
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Integer health;
    private static final Integer DEFAULT_HEALTH = 100;


    public Character(@NonNull String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character other);

    public void reduceHealth(Integer damage){
        this.health -= damage;
    }
}

