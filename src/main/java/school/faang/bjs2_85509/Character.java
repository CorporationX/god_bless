package school.faang.bjs2_85509;

import lombok.Data;

@Data
abstract class Character {
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intellegence;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intellegence = 5;
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
