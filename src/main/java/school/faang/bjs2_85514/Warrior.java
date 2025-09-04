package school.faang.bjs2_85514;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("\n" + getName() + " атакует " + opponent.getName() +
                " и наносит " + getStrength() + " урона!");
        opponent.decreaseHealth(getStrength());
    }
}
