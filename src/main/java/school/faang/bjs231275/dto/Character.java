package school.faang.bjs231275.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    protected String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intellect;
    protected Integer health;

   public Character(String name) {
       this(name, 0, 0, 0);
    }

    public Character(String name, int power, int agility, int intellect) {
       this.name = name;
       this.health = 100;
       this.power = power;
       this.agility = agility;
       this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
