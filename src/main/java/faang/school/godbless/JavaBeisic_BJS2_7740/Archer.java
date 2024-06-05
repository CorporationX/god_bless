package faang.school.godbless.JavaBeisic_BJS2_7740;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 7, 5);  // сила 3, ловкость 10, интеллект 5
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.agility);
        System.out.println(this.name + " атакует " + target.getName() + " и наносит " + this.agility + " урона.");
    }
}

