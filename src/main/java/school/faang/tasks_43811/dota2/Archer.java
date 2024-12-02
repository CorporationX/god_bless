package school.faang.tasks_43811.dota2;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 50, 5);
    }

    @Override
    public void attack(Character target) {
        if (!this.isAlive()) {
            System.out.println(getName() + " мёртв и не может атаковать.");
            return;
        }
        if (!target.isAlive()) {
            System.out.println(target.getName() + " уже мёртв.");
            return;
        }
        int damage = target.getHeatPoint() - this.getAgility();
        target.setHeatPoint(damage);
        System.out.println(
                getName() + " стреляет в " + target.getName()
                        + " и наносит " + this.getAgility()
                        + " урона. Осталось " + damage + " здоровья."
        );
    }
}