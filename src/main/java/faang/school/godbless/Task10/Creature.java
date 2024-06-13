package faang.school.godbless.Task10;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Creature {

    private String name;
    protected int level;
    protected int damage;
    protected int defense;
    protected int haste;
    protected int quantity;

    public abstract int getDmg();

    public Creature(String name) {
        this.name = name;
    }

}
