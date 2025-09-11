package school.faang.rpg.game;

import school.faang.rpg.game.characters.Archer;
import school.faang.rpg.game.characters.Warrior;

public class Fight {
    public static void main(String[] args) {

        Warrior warriorOpponent = new Warrior("BadIya");
        Archer archer = new Archer("GoodIya");

        while (warriorOpponent.getHealth() > 0) {
            archer.attack(warriorOpponent);
        }
        archer.attack(warriorOpponent);
        System.out.println(archer);
        System.out.println(warriorOpponent);

    }
}
