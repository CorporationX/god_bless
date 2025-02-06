package school.faang.abstraction_abstraction.BJS2_56401;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Warrior ronal = new Warrior("Ronal");
        Archer youseiYunde = new Archer("Yousei Yunde");

        System.out.println(ronal.getName() + " HP = " + ronal.getHealth());
        System.out.println(youseiYunde.getName() + " HP = " + youseiYunde.getHealth());

        youseiYunde.attack(ronal);
        System.out.println(ronal.getName() + " HP = " + ronal.getHealth());

        for (int i = 0; i < 3; i++) {
            ronal.attack(youseiYunde);
            System.out.println(youseiYunde.getName() + " HP = " + youseiYunde.getHealth());
        }

        for (int i = 0; i < 15; i++) {
            youseiYunde.attack(ronal);
            System.out.println(ronal.getName() + " HP = " + ronal.getHealth());
        }
    }
}
