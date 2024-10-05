package school.faang.heroes;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer power;
    private Integer agility;
    private Integer intellect;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer agility, Integer intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public void showHealth() {
        System.out.printf("Здоровье %s %d\n", this.getName(), this.getHealth());
    }
    public void takeDamage(Integer damage) {
        this.health -= damage;
    }

    abstract void attack(Character character);
}