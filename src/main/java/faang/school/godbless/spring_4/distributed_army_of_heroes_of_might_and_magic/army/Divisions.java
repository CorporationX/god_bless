package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army;

public abstract class Divisions {
    private final int power;

    public Divisions(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
