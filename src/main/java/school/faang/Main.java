package school.faang;

import school.faang.bjs2_68112.Archer;
import school.faang.bjs2_68112.Character;
import school.faang.bjs2_68112.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Vasiliy");
        Character archer = new Archer("Stepan");
        System.out.printf("warrior before attack: %s\n".formatted(warrior));
        System.out.printf("archer before attack: %s\n".formatted(archer));
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.printf("warrior after attack: %s\n".formatted(warrior));
        System.out.printf("archer after attack: %s\n".formatted(archer));
    }
}
