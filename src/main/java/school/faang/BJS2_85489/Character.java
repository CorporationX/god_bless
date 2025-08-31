package school.faang.BJS2_85489;

public abstract class Character {
    String name;
    double strength;
    double dexterity;
    double intelligence;
    double health = 100;

    public Character(String name) {
        this.name = name;
        strength = 5;
        dexterity = 5;
        intelligence = 5;
    }

    public Character(String name, double strength, double dexterity, double intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    boolean isLive(double damage) {
        return health - damage > 0 ? true : false;
    }

    abstract void attack(Character opponent);

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
