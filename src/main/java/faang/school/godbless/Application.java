package faang.school.godbless;

import java.io.Console;
import java.lang.module.Configuration;
import java.util.Random;
import java.util.Scanner;

import static faang.school.godbless.Battlefield.battle;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");

        Event.initHero();
        Event.initArmy(Event.getFirstHero());
        Event.initArmy(Event.getSecondHero());

        Scanner console = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println(Event.getFirstHero().getName() + "!" + "\n" + "Куда поведем войска!?");
            System.out.println("По дороге, что идет right или left?");
            Random random = new Random();
            String answer = console.nextLine();
            if (answer.equals("right".toLowerCase())) {
                int cube = random.nextInt(7);
                Battlefield.round(Event.getFirstHero(), cube);
            } else if (answer.equals("left".toLowerCase())) {
                int cube = random.nextInt(7);
                Battlefield.round(Event.getFirstHero(), cube);
            }

            System.out.println(Event.getSecondHero().getName() + "!" + "\n" + "Куда поведем войска!?");
            System.out.println("По дороге, что идет right или left?");
            answer = console.nextLine();
            if (answer.equals("right")) {
                int cube = random.nextInt(7);
                Battlefield.round(Event.getSecondHero(), cube);
            } else if (answer.equals("left")) {
                int cube = random.nextInt(7);
                Battlefield.round(Event.getSecondHero(), cube);
            }
        }

        battle();

    }
}