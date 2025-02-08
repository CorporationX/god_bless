package school.faang.naughtwoBJS256522;

import school.faang.naughtwoBJS256522.character.Archer;
import school.faang.naughtwoBJS256522.character.Character;
import school.faang.naughtwoBJS256522.character.Warrior;

public class Main {
    public static void main(String[] args) {
        Character vladislav = new Warrior("Vladislav");
        Character viago = new Archer("Viago");
        vladislav.attack(viago);
        for (int i = 0; i < 12; i++) {
            viago.attack(vladislav);
        }
        vladislav.attack(viago);
        System.out.println(viago);
        System.out.println(vladislav);
    }
}
