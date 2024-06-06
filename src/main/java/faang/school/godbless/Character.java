package faang.school.godbless;

public class Character {
    protected String name;
    private int force;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + " Illegal name");
        }

        if (force > 0 && force <= 100) {
            this.force = force;
        } else {
            throw new IllegalArgumentException(force + " is too much");
        }

        if (dexterity > 0 && dexterity <= 100) {
            this.dexterity = dexterity;
        } else {
            throw new IllegalArgumentException(dexterity + " is too much");
        }

        if (intelligence > 0 && intelligence <= 100) {
            this.intelligence = intelligence;
        } else {
            throw new IllegalArgumentException(intelligence + " is too much");
        }
    }
}