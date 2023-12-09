package faang.school.godbless.Hiroes;

import java.util.List;

public class Battlefield {
    private Hero hero;
    private Hero hero1;
    private List<Creature> armyHero;
    private List<Creature> armyHero1;


    public Battlefield(Hero hero, Hero hero1, List<Creature> armyHero, List<Creature> armyHero1) {
        this.hero = hero;
        this.hero1 = hero1;
        this.armyHero = armyHero;
        this.armyHero1 = armyHero1;
    }

    public Hero battle() {
        int move = 0;
        for (int i = 0; i < armyHero.size() || i < armyHero1.size(); i++) {
            if (move % 2 == 0) {
                armyHero.remove(armyHero.get(1));
            } else {
                armyHero1.remove(armyHero1.get(1));
            }
            move++;

        }
        if (armyHero.size() == 0) {
            return hero1;
        } else {
            return hero;
        }
    }

}
