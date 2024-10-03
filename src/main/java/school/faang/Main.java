package school.faang;

import school.faang.Abstract.Archer;
import school.faang.Abstract.Character;
import school.faang.Abstract.Warrior;

public class Main {
    public static void main(String[] args) {
        Character arthas = new Warrior("Arthas");
        Character silvana = new Archer("Silvana");

        arthas.attack(silvana);
        System.out.println(silvana.getHealth());
        silvana.attack(arthas);
        System.out.println(arthas.getHealth());
    }
}
