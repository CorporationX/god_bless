package school.faang.BJS2_85677;

public abstract class Character {
    String name;
    int strength;
    int agility;
    int intellect;
    int health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intellect = 5;
    }

    public Character(int intellect, int agility, int strength, String name) {
        this.intellect = intellect;
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }

    public void healthLevelCheking(Character character) {
        if (character.health < 0) {
            character.health = 0;
        }
    }

    public void attack(Character opponent) {
    }
}
