package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Unit {
    public int power;

    static class Archer extends  Unit {
        public Archer(int power) {
            super(power);
        }
    }

    static class Warrior extends  Unit {
        public Warrior(int power) {
            super(power);
        }
    }

    static class Mage extends  Unit {
        public Mage(int power) {
            super(power);
        }
    }
}

