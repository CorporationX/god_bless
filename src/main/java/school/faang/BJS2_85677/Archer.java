package school.faang.BJS2_85677;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.agility;
        healthLevelCheking(opponent);
    }
}
