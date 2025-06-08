package school.faang.bjs2_79362;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " атакует " + opponent.getName() +
                " с силой удара равной ловкости " + agility);
        opponent.reduceHealth(agility);
    }
}

