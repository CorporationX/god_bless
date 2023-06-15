package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public String attack(Character character) {
        if (character.getHeath() == 0) {
            return character + " помер";
        }
        int remainHealth = character.getHeath() - agility;
        return "Здоровья осталось " + remainHealth;
    }
}
