package faang.school.godbless.abstraction;

import faang.school.godbless.abstraction.characters.Archer;
import faang.school.godbless.abstraction.characters.Character;
import faang.school.godbless.abstraction.characters.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warriorAdolf = new Warrior("Adolf");
        Character archerIosif = new Archer("Iosif");
        battle(warriorAdolf,archerIosif);
    }
    public static void battle(Character warriorOne, Character warriorTwo){
        while (true) {
            warriorTwo.attack(warriorOne);
            if (warriorOne.getHealth() <= 0) {
                System.out.printf("""

                        ...:::::::::::::The Winner::::::::::::...
                        ** %s **
                        It has %d HP
                        """, warriorTwo.getName(), warriorTwo.getHealth());
                break;
            }
            warriorOne.attack(warriorTwo);
            if (warriorTwo.getHealth() <= 0) {
                System.out.printf("""

                        ...:::::::::::::The Winner::::::::::::...
                        ** %s **
                        It has %d HP
                        """, warriorOne.getName(), warriorOne.getHealth());
                break;
            }
        }
    }
}
