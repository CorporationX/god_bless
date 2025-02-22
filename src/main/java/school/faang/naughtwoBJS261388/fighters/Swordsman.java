package school.faang.naughtwoBJS261388.fighters;


import lombok.NonNull;


public class Swordsman extends Fighter {

    public Swordsman(int power) {
        super(power);
    }

    public Swordsman(@NonNull String name, int power) {
        super(name, power);
    }
}
