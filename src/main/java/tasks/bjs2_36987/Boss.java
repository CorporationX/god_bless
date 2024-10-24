package tasks.bjs2_36987;

import lombok.Getter;

@Getter
public class Boss {
    private int health;

    public Boss(int maxHealth) {
        this.health = maxHealth;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            System.out.println("Босу нанесли урон : " + damage + ". Здоровье после атаки : " + health);
        } else {
            System.out.println("В группе нет игроков для битвы с боссом");
        }
    }


}
