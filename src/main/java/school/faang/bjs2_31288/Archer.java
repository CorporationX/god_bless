package school.faang.bjs2_31288;

public class Archer extends Character{

    public Archer(String name) {
        super(name,
            3,
            10,
            5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " атакует " + opponent.name + " с ловкостью" + agility);
        opponent.takeDamage(agility);
    }
}
