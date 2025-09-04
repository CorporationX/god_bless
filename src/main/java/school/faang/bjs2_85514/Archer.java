package school.faang.bjs2_85514;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("\n" + getName() + " атакует " + opponent.getName() +
                " и наносит " + getAgility() + " урона!");
        opponent.decreaseHealth(getAgility());
    }
}
