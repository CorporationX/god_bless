package school.faang.bjs2_68140;

public class Warrior extends Character {
    public Warrior(String name) {
        super();
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
        this.name = name;
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth()
                - calculateMaxDamage(opponent, this.getStrength()));
    }
}
