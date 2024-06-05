package faang.school.godbless.abstracting;

public abstract class Character {
    protected String name;
    protected int force, dexterity, intelest;
    protected int health = 100;

    public Character(String name, int force, int dexterity, int intelest) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelest = intelest;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", dexterity=" + dexterity +
                ", intelest=" + intelest +
                ", health=" + health +
                '}';
    }
}
