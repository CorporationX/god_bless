package school.faang.bjs2_86417_1_1_2_3_abstraction_abstraction;

public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_CHARACTERISTIC = 5;

    protected String name;
    protected Integer strength;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_CHARACTERISTIC;
        this.dexterity = DEFAULT_CHARACTERISTIC;
        this.intelligence = DEFAULT_CHARACTERISTIC;
    }
    public Character(String name, Integer strength,Integer dexterity, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void checkHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
    }

}
