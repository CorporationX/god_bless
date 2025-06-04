package school.faang.abstraction79174;

public class SuperBoss extends Character {
    public SuperBoss(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.power;
        checkHealth(opponent);
    }
}
