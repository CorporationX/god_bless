package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army;

public abstract class Division {
    private final int power;

    public Division(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
