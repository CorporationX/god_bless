package faang.school.godbless.completablefuture.arena;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Robot {

    private final int id;
    private final String name;
    @Setter
    private int hp;
    @Setter
    private boolean isAlive;
    @Setter
    private boolean isAttacking;
    @Setter
    private boolean isInterrupted;
    private final int attackPower;
    private final double attackSpeed;

    public Robot(int id, String name, int hp, int attackPower, double attackSpeed) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.attackSpeed = attackSpeed;
        isAlive = true;
        isAttacking = false;
        isInterrupted = false;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            setAlive(false);
        }
    }

}
