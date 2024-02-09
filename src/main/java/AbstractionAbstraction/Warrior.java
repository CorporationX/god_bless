package AbstractionAbstraction;

public class Warrior {
    private String name;
    private int force = 10;
    private int agility = 5;
    private int intelligence = 3;
    private int health = 100;

    @Override
    Warrior(String name) {
        this.name = name;
    }

    @Override
    Warrior(String name, int force, int agility, int intelligence) {
        this.name = name;
    }
}
