package school.faang.BJS2_85677;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intellect = 3;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.strength;
        healthLevelCheking(opponent);
    }
}
