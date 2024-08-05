package faang.school.godbless.gameHeroesOfMight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public abstract class Creature {
    private String name;
    private int level = 1;
    private int attack ;
    private int protection;
    private int speed;
    @EqualsAndHashCode.Exclude
    private int amount = 0;

    public Creature(String name, int attack, int protection, int speed) {
        this(name);
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
    }

    public Creature(String name, int level, int attack, int protection, int speed, int amount) {
        this(name);
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.amount = amount;
    }

    public Creature(String name) {
        this.name = name;
    }

    abstract int getDamage();
}
