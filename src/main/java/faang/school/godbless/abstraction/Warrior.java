package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attac(Character character) {
        int warriorAttac = getPower();
        int remainingHealth = character.health - warriorAttac;
        System.out.println(getName() + " атакует " + character.getName() + "\n"
                + character.getName() + " туряет " + warriorAttac + " здоровья \n"
                + "у " + character.getName() + " ocталось " + remainingHealth + " здоровья");
    }
}
