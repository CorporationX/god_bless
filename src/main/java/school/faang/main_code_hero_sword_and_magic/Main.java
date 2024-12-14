package school.faang.main_code_hero_sword_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Creature> firstHeroArmy = new ArrayList<>();
        List<Creature> secondHeroArmy = new ArrayList<>();

        Hero firstHero = new Hero("бетмен", "орда", 0, 1, firstHeroArmy);
        Hero secondHero = new Hero("супермен", "альянс", 0, 1, secondHeroArmy);

        firstHero.addCreature(new Swordman("Swordman"), 10);
        firstHero.addCreature(new Pikeman("Pikeman"), 10);
        secondHero.addCreature(new Griffin("Griffin"), 10);
        secondHero.addCreature(new Angel("Angel"), 10);

        Battelfield battelfield = new Battelfield();

        Hero winner = battelfield.battle(firstHero, secondHero);

        if (winner != null) {
            System.out.println("Выиграл герой " + winner.getName());
        } else {
            System.out.println("Ничья");
        }
    }
}
