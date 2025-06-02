package school.faang.abstraction79174;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character opponent) {
        opponent.health -= this.power;
        checkHealth(opponent);
    }
}
