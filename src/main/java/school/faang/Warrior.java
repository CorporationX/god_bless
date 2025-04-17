package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s атакует %s с силой %d%n", this.name, opponent.getName(), this.strength);
        opponent.reduceHealth(this.strength);
    }
}