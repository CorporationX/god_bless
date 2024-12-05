package school.faang.sprint1.bjs_43880;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\nЗдоровье: " + health +
                "\nСила: " + force + "\nЛовкость: " + dexterity +
                "\nИнтеллект: " + intelligence + "\n";
    }

    public abstract void attack(Character character);
}
