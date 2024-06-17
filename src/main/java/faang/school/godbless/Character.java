package faang.school.godbless;

public abstract class Character {
    private String name;
    protected int power;
    protected int sleight;
    protected int intellect;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int intellect, int sleight) {
        this.power = power;
        this.intellect = intellect;
        this.sleight = sleight;
    }

    public void attack(Character character) {}
}
