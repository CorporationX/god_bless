package school.faang.module1.bjs2_79178;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {

        System.out.println(name + " выпускает стрелу в " + opponent.name);
        opponent.takeDamage(agility);
    }
}
