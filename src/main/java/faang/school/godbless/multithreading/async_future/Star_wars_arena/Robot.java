package faang.school.godbless.multithreading.async_future.Star_wars_arena;

import lombok.Data;

@Data
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void attack(Robot opponent) {
        opponent.setDefensePower(opponent.getDefensePower() - attackPower);
    }
}
