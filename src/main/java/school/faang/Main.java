package school.faang;

import school.faang.character.Archer;
import school.faang.character.Character;
import school.faang.character.Warrior;

public class Main {
    public static void main(String[] args) {
        Character vladislav = new Warrior("Vladislav");
        Character viago = new Archer("Viago");
        vladislav.attack(viago);
        viago.attack(vladislav);
        System.out.println(viago);
        System.out.println(vladislav);
    }
}
