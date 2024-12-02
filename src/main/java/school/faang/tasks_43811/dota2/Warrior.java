package school.faang.tasks_43811.dota2;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 12, 5, 3);
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
        int damage = target.getHeatPoint() - this.getStrength();
        target.setHeatPoint(damage);
        System.out.println(
                getName() + " ударяет " + target.getName()
                        + " и наносит " + this.getStrength()
                        + " урона. Осталось " + damage + " здоровья."
        );
    }

}