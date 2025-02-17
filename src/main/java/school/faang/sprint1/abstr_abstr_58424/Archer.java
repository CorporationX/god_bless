package school.faang.sprint1.abstr_abstr_58424;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("Лучник %s наносит %d урона%n", getName(), getAgility());
        reduceHealth(opponent, getAgility());
    }

}
