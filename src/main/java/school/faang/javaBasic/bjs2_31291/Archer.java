package school.faang.javaBasic.bjs2_31291;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
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
    }


    @Override
    public void receiveDamage(int damage) {
        takeDamage(damage);
        if (this.getHealth() <= 0) {
            die();
        }
    }

    private void activateLowHealthAbility() {
    }

    protected void activateAbility() {
        System.out.println(this.getName() + " активирует способность при низком здоровье!");
    }
}
