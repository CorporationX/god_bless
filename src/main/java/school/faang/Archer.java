package school.faang;

public class Archer extends Character {

    public static final int MAX_STRENGTH = 3;
    public static final int MAX_AGILITY = 10;
    public static final int MAX_INTELLECT = 5;

    public Archer(String name) {
        super(name, MAX_STRENGTH, MAX_AGILITY, MAX_INTELLECT);
    }

    public void attack(Character opponent) {
        opponent.reduceHealth(getAgility());
        System.out.println(this.getName() + " атакует " + opponent.getName() + " и наносит " + MAX_AGILITY + " урона ");
    }
}