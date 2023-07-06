package faang.school.godbless.Sprint4.SuperheroesBattle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class Superhero {
    private String name;
    private int strength;
    private int agility;
    @Setter
    private int health;
    private int fullHp;


    public Superhero(String name, int strength, int agility, int health) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.health = health;
        this.fullHp = health;
    }

}
