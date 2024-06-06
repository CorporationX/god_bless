package testing;

import faang.school.godbless.Archer;
import faang.school.godbless.Character;
import faang.school.godbless.Warrior;

public class Application {
    public static void main(String[] args) {
        Character Geralt = new Warrior("Geralt");
        Character Elf = new Archer("Vingels");

        Geralt.attack(Elf);
        Elf.attack(Geralt);
    }
}