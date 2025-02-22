package school.faang.naughtwoBJS261388.fighters;

import lombok.NonNull;

public class Archer extends Fighter {

    public Archer(int power) {
        super(power);
    }

    public Archer(@NonNull String name, int power) {
        super(name, power);
    }
}
