package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public String attack(Character character) {
        int remainHealth = character.getHeath() - strength;
        return "Здоровья осталось у " + remainHealth;
    }
}
