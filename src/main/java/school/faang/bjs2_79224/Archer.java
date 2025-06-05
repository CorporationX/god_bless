package school.faang.bjs2_79224;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.giveDamage(agility);
        System.out.println(name + " стреляет в " + opponent.name);

        if (opponent.isDead()) {
            System.out.println(name + " побеждает");
        }
    }
}
