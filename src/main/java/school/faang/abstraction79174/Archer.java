package school.faang.abstraction79174;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character opponent) {
        opponent.health -= this.getDexterity();
        checkHealth(opponent);
    }
}
