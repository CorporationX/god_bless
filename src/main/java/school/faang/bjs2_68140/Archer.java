package school.faang.bjs2_68140;

public class Archer extends Character {
    public Archer(String name) {
        super();
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
        this.name = name;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth()
                - calculateMaxDamage(opponent, this.getAgility()));
    }
}
