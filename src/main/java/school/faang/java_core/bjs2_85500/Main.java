package school.faang.java_core.bjs2_85500;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Character[] characters = {
                new Warrior("Warrior"),
                new Archer("Archer")
        };

        Random random = new Random();
        int attacker;

        for (int i = 0; i < 10; i++) {
            attacker = random.nextInt(2);
            characters[attacker].attack(characters[1 - attacker]);
        }

        System.out.println("Warrior health: " + characters[0].getHealth()
                + "\nArcher health: " + characters[1].getHealth());
    }
}
