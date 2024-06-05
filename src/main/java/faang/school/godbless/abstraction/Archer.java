package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attac(Character character) {
        int archerAttac = getPower();
        int remainingHealth = character.health - archerAttac;
        System.out.println(getName() + " атакует " + character.getName() + "\n"
                + character.getName() + " туряет " + archerAttac + " здоровья \n"
                + "у " + character.getName() + " ocталось " + remainingHealth + " здоровья");
    }
}