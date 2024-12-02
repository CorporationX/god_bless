package school.faang.tasks_43811.dota2;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        int damage = target.getHeatPoint() - this.getAgility();
        target.setHeatPoint(damage);
        System.out.println(
                getName() + " стреляет в " + target.getName()
                        + " и наносит " + this.getAgility()
                        + " урона. И оставляет " + damage + " здоровья"
        );
    }
}