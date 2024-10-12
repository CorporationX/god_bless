package school.faang.character.classes;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        int damage = getPower();
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(getName() + " наносит " + enemy.getName() + " " + damage + " урона");
    }
}
