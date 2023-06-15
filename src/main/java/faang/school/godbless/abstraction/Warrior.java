package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public String attack(Character character) {
        if (character.getHeath() == 0) {
            return character + " помер";
        }
        int remainHealth = character.getHeath() - strength;
        return "Здоровья осталось у " + remainHealth;
    }
}
