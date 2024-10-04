package school.faang.javaBasic.bjs2_31291;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Warrior extends Character {


    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        if (enemy == null) {
            System.out.println(this.getName() + " не может атаковать, враг не найден.");
            return;
        }
        Random random = new Random();
        int damage = random.nextInt(90) + 1;
        enemy.receiveDamage(damage);
        System.out.println(this.getName() + " атакует - " + enemy.getName() + " нанося : " + damage + " урон");
    }

    private void die() {
        System.out.println(this.getName() + " погиб.");
        // Дополнительная логика смерти
    }

    private void activateLowHealthAbility() {
        System.out.println(this.getName() + " активирует способность при низком здоровье!");
        // Логика активации способности
    }

    public void receiveDamage(int damage) {
        // Логика получения урона
        this.setHealth(this.getHealth() - damage);

        if (this.getHealth() <= 0) {
            // Логика смерти
            this.die();
            System.out.println("Умер");
        } else if (this.getHealth() < this.getMaxHealth() * 0.2) {
            activateLowHealthAbility();
        }
    }
}
