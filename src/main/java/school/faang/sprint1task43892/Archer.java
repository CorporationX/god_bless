package school.faang.sprint1task43892;

public class Archer extends Character {
    public static final int STRENGTH = 3;
    public static final int AGILITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, 100);
    }

    @Override
    public void attack(Character character) {
        if (isAlive()) {
            character.receiveDamage(agility);
        } else {
            System.out.println(this.name + " не может атаковать, так как уже мёртв.");
        }
    }
}