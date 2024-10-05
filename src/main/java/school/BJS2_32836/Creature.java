package school.BJS2_32836;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class Creature {

    protected String name;
    protected int lvl;
    protected int attack;
    protected int protect;
    protected int speed;
    @Setter
    protected int health;

    public abstract int getDamage();

    /*
    Изменил логику нанесение урона. Теперь урон снижается в проценте от защиты врага
     */
    public void attackEnemy(Creature enemy, Hero myHero, Hero enemyHero) {
        int damagePercentage = getDamage() * (1 - enemy.getProtect() / 100);
        int damageFromLVL = (int) (0.3 * this.lvl);
        int damage = damagePercentage + damageFromLVL;
        enemy.setHealth(enemy.getHealth()-damage);
        System.out.printf("Существо %s из армии Героя %s наносит урон существу %s Героя %s", name, myHero.getName(), enemy.getName(), enemyHero.getName());
        System.out.println();
        if (enemy.getHealth() <= 0) {
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