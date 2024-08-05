package faang.school.godbless.BJS2_18732;

public abstract class Character {
    private String name;
    protected int force;
    private int dexterity;
    private int intelligence;
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

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }

    public abstract void attack(Character character);
}
