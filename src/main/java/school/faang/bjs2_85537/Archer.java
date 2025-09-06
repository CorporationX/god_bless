package school.faang.bjs2_85537;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attack %s\n", name, opponent.name);
        opponent.health = opponent.health - this.agility;
        opponent.checkHealth();
        System.out.printf("%s has %d HP\n", opponent.name, opponent.health);
    }
}
