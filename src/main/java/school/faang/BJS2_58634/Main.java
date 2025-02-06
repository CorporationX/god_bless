package school.faang.BJS2_58634;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Warrior voin = new Warrior("Andrey");
        Archer luchnik = new Archer("Katya");

        Random random = new Random();
        int whoAttack = random.nextInt(2) + 1;

        if (whoAttack == 1) {
            voin.attack(luchnik);
        } else {
            luchnik.attack(voin);
        }
    }
}
