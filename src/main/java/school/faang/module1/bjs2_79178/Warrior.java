package school.faang.module1.bjs2_79178;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {

        System.out.println(name + " наносит удар " + opponent.name);
        opponent.takeDamage(strength);
    }
}
