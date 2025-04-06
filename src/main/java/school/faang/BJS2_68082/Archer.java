package school.faang.BJS2_68082;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5); // сила 3, ловкость 10, интеллект 5
    }

    @Override
    public void attack(Character opponent) {
        reduceHealth(opponent, this.agility);
    }
}
