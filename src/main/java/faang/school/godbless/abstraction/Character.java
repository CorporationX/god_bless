package faang.school.godbless.abstraction;

public abstract class Character {
    protected String name;
    protected float force;
    protected float dexterity;
    protected float intelligence;
    protected float health = 100;

    public Character(String name) {
        validateName(name);
        this.name = name;
    }

    public Character(String name, float force, float dexterity, float intelligence) {
        this(name);
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void setHealth(float healthPoints) {
        if (healthPoints <= 0 ) {
            throw new IllegalArgumentException("Health <= 0");
        }
        health = healthPoints;
    }

    public abstract void attack(Character unit);

    private void validateName(String name){
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name field cannot be empty");
        }
    }
}
