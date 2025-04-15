package school.faang;

public class Warrior extends Character {

    public static final int MAX_STRENGTH = 10;
    public static final int MAX_AGILITY = 5;
    public static final int MAX_INTELLECT = 3;

    public Warrior(String name) {
        super(name, MAX_STRENGTH, MAX_AGILITY, MAX_INTELLECT);
    }

    public void attack(Character opponent) {

        opponent.reduceHealth(this.getStrength());
        System.out.println(this.getName() + " атакует " + opponent.getName() + " и наносит " + MAX_STRENGTH + " урона.");
    }
}