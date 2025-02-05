package school.faang;

import school.faang.models.Archer;
import school.faang.models.Character;
import school.faang.models.Warrior;

public class Main {
    public static void main(String[] args) {
        Character barbarian = new Warrior("Конан варвар");
        Character elf = new Archer("Леголас");
        Character ork = new Archer("Черный орк (лучник)");

        System.out.println("У " + ork.getName() + " было здоровья - " + ork.getHealth()
                + ". А после удара, осталось здоровья " + barbarian.attack(ork));
        System.out.println("Сила удара у " + barbarian.getName() + " составляет " + barbarian.getStrength());
    }
}
