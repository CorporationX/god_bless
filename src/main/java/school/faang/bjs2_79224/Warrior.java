package school.faang.bjs2_79224;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.giveDamage(strength);
        System.out.println(name + " наносит удар по " + opponent.name);

        if (opponent.isDead()) {
            System.out.println(name + " побеждает");
        }
    }
}
