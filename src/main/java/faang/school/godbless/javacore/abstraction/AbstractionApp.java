package faang.school.godbless.javacore.abstraction;

import faang.school.godbless.javacore.abstraction.characters.Archer;
import faang.school.godbless.javacore.abstraction.characters.Character;
import faang.school.godbless.javacore.abstraction.characters.Warrior;

import java.util.random.RandomGenerator;

public class AbstractionApp {

    public static void main(String[] args) {
        Character warrior = new Warrior("Garrosh");
        Character archer = new Archer("Sylvanas");
        duel(warrior, archer);
    }

    private static void duel(Character fighter1, Character fighter2) {
        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            fighter1.attack(fighter2);
            fighter2.setHp(fighter2.getHp() + RandomGenerator.getDefault().nextInt(-5, 5));
            System.out.println(fighter2.getName() + " was attacked! His HP = " + fighter2.getHp());
            if(fighter2.getHp() <= 0) {
                System.out.println(fighter1.getName() + " Won!");
                break;
            }

            fighter2.attack(fighter1);
            fighter1.setHp(fighter1.getHp() + RandomGenerator.getDefault().nextInt(-5, 5));
            System.out.println(fighter1.getName() + " was attacked! His HP = " + fighter1.getHp());
            if(fighter1.getHp() <= 0) {
                System.out.println(fighter2.getName() + " Won!");
                break;
            }
        }
    }

}