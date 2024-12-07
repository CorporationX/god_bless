package school.faang.sprint1task43892;

public class Warrior extends Character {
    public static final int STRENGTH = 10;
    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, 100);

        this.strength = STRENGTH;
        this.agility = AGILITY;
        this.intelligence = INTELLIGENCE;
    }

    @Override
    public void attack(Character character) {
        if (isAlive()) {
            character.receiveDamage(strength);
        } else {
            System.out.println(this.name + " не может атаковать, так как уже мёртв.");
        }
    }
}