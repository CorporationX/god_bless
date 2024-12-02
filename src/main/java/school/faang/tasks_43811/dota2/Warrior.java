package school.faang.tasks_43811.dota2;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 12, 5, 3);
    }

    @Override
    public void attack(Character target) {
        int damage = target.getHeatPoint() - this.getStrength();
        target.setHeatPoint(damage);
        System.out.println(
                getName() + " ударяет " + target.getName() + " и наносит " +
                        this.getStrength() + " урона. И оставляет " + damage + " здоровья"
        );
    }
}