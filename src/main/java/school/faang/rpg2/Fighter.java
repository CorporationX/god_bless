package school.faang.rpg2;

public abstract class Fighter {
    protected int power;

    public Fighter(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
