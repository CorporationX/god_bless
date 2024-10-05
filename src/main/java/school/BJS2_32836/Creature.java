package school.BJS2_32836;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Creature {

    protected String name;
    protected int lvl;
    protected int attack;
    protected int protect;
    protected int speed;
    @Setter
    protected int health = 100;

    public Creature(String name, int lvl, int attack, int protect, int speed) {
        this.name = name;
        this.lvl = lvl;
        this.attack = attack;
        this.protect = protect;
        this.speed = speed;
    }

    protected abstract int getDamage();

    protected void attackEnemy(Creature creature, Hero hero, Hero hero2) {
        if (creature.getHealth() - (getDamage() - (int) (0.2 * creature.getProtect())) > creature.getHealth()) {
            creature.setHealth(100);
            System.out.printf("Существо %s из армии Героя %s наносит урон существу %s Героя %s", name, hero.getName(), creature.getName(), hero2.getName());
            System.out.println();
        } else {
            creature.setHealth(creature.getHealth() - (getDamage() + (int) (0.3 * this.lvl) - (int) (0.2 * creature.getProtect())));
            System.out.printf("Существо %s из армии Героя %s наносит урон существу %s Героя %s", name, hero.getName(), creature.getName(), hero2.getName());
            System.out.println();
        }
        if (creature.getHealth() <= 0) {
            this.lvl = this.lvl + 1;
            System.out.printf("%s повышает уровень за убийство", name);
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Creature{" +
                "lvl=" + lvl +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", protect=" + protect +
                ", speed=" + speed +
                '}';
    }
}