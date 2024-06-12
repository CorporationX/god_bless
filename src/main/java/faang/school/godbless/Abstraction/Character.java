package faang.school.godbless.Abstraction;

public abstract class Character {
    protected String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void getInjured(int force) {
        this.health = this.health - force;

        if (!this.isAlive()) {
            System.out.println(this.name + " died \n");
        } else {
            System.out.println(this.getName() + " health is " + this.getHealth() + "\n");
        }
    }

    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void attack(Character enemy);

    public void setName(String name) throws IllegalArgumentException{
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException(name + " Illegal name");
        }
    }

    public void setForce(int force) throws IllegalArgumentException{
        if (force > 0 && force <= 100) {
            this.force = force;
        } else {
            throw new IllegalArgumentException(force + " is too much");
        }
    }

    public void setDexterity(int dexterity) throws IllegalArgumentException{
        if (dexterity > 0 && dexterity <= 100) {
            this.dexterity = dexterity;
        } else {
            throw new IllegalArgumentException(dexterity + " is too much");
        }
    }

    public void setIntelligence(int intelligence) throws IllegalArgumentException{
        if (intelligence > 0 && intelligence <= 100) {
            this.intelligence = intelligence;
        } else {
            throw new IllegalArgumentException(intelligence + " is too much");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getForce() {
        return this.force;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public String toString() {
        return "|" + this.name + "| force: " + this.force + ", dexterity: " + this.dexterity +
                ", intelligence: " + this.intelligence + ", health: " + this.health;
    }
}