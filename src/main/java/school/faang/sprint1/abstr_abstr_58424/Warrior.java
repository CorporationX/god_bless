package school.faang.sprint1.abstr_abstr_58424;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("Воин %s наносит %d урона%n", getName(), getStrength());
        reduceHealth(opponent, getStrength());
    }


}
