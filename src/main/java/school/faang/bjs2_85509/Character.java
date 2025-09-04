package school.faang.bjs2_85509;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer strength = 5;
    private Integer agility = 5;
    private Integer intellegence = 5;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intellegence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellegence = intellegence;
    }

    abstract void attack(Character opponent);

    protected void validateHealth(int health) {
        if (health <= 0) {
            this.health = 0;
            System.out.println(name + " defeated");
        }
    }
}
