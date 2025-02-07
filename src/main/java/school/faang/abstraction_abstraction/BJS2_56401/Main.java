package school.faang.abstraction_abstraction.BJS2_56401;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Warrior ronal = new Warrior("Ronal");
        Archer youseiYunde = new Archer("Yousei Yunde");

        LOGGER.info("Creating {} and {}", ronal, youseiYunde);

        System.out.println(ronal.getName() + " HP = " + ronal.getHealth());
        System.out.println(youseiYunde.getName() + " HP = " + youseiYunde.getHealth());

        youseiYunde.attack(ronal);
        System.out.println(ronal.getName() + " HP = " + ronal.getHealth());

        LOGGER.info("{} attacked", youseiYunde);

        for (int i = 0; i < 3; i++) {
            ronal.attack(youseiYunde);
            System.out.println(youseiYunde.getName() + " HP = " + youseiYunde.getHealth());

            LOGGER.info("{} attacked", ronal);
        }

        for (int i = 0; i < 15; i++) {
            youseiYunde.attack(ronal);
            System.out.println(ronal.getName() + " HP = " + ronal.getHealth());

            LOGGER.info("{} attacked", youseiYunde);
        }
    }
}
