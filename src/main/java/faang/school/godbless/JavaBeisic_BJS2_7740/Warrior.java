package faang.school.godbless.JavaBeisic_BJS2_7740;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);  // сила 10, ловкость 5, интеллект 3
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.strength);
        System.out.println(this.name + " атакует " + target.getName() + " и наносит " + this.strength + " урона.");
    }
}
