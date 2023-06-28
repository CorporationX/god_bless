package faang.school.godbless.heroes;

import lombok.Getter;

@Getter
public class UnitThread extends Thread {
    private int power;
    private final Entity entity;

    public UnitThread(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void run() {
        this.power = entity.getPower();
    }
}
