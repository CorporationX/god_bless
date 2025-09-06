package school.faang.bjs2_85537;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attack %s\n", name, opponent.name);
        opponent.health = opponent.health - this.strength;
        opponent.checkHealth();
        System.out.printf("%s has %d HP\n", opponent.name, opponent.health);
    }
}
