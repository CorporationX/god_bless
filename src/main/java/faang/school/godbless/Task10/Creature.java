package faang.school.godbless.Task10;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter

public abstract class Creature {

    private String name;
    private int level;
    private int damage;
    private int defense;
    private int haste;
    private int quantity;

}
