package school.faang.bjs2_79362;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " атакует " + opponent.getName() +
                " с силой " + strength);
        opponent.reduceHealth(strength);
    }
}

