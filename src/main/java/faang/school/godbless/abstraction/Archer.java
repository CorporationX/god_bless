package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public String attack(Character character) {
        int remainHealth = character.getHeath() - agility;
        return "Здоровья осталось " + remainHealth;
    }
}
