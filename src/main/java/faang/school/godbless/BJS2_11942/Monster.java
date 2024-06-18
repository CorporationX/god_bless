package faang.school.godbless.BJS2_11942;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Monster extends Creature {

    public Monster(String name, Location location) {
        super(name, location);
    }

    public long getKillTime() {
        // пусть на любого монстра будет рандомное время убийства
        return (long) (Math.random() * 1000 + 1);
    }
}
